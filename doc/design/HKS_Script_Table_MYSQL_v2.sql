drop table if exists hks_company;
drop table if exists hks_user;
drop table if exists hks_account;
drop table if exists hks_role;
drop table if exists hks_privileges;
drop table if exists hks_cat;
drop table if exists hks_workflow;
drop table if exists hks_status_object;
drop table if exists hks_items;
drop table if exists hks_item_versions;
drop table if exists hks_item_access;
drop table if exists hks_attach_file;
drop table if exists hks_feedback;
drop table if exists hks_contact;
drop table if exists hks_parameter_config;
drop table if exists hks_comments;
drop table if exists hks_response_comment;
drop table if exists hks_chat;
drop table if exists hks_chat_line;
drop table if exists hks_mechanism_type;
drop table if exists hks_mechanism;
drop table if exists hks_mechanism_report;
drop table if exists hks_streaming;
drop table if exists hks_recruiting;
drop table if exists hks_seeking;

create table hks_company (
	  id int not null auto_increment
	, name nvarchar(1024) not null
	, phone nvarchar(20) not null
	, introduce nvarchar(4000) not null
	, address nvarchar(1024) not null
	, city nvarchar(512) not null
	, created datetime not null
	, createdby_username varchar(50) not null
	, lastmodified datetime
	, lastmodifiedby_username varchar(50)
	, primary key (id)
);

create table hks_user (
      id int not null auto_increment
    , email varchar(50)
    , firstname nvarchar(20)
    , lastname nvarchar(50)
    , avatar LONGBLOB						  	-- avatar image of user
    , created datetime not null
    , commpany int,								-- Refer to hks_company
    , company_id int,							-- Id of company
    , createdby_username varchar(50) not null
    , lastmodified datetime
    , lastmodifiedby_username varchar(50) 
    , primary key (id)
    , foreign key (company) references hks_company(id)
);

create table hks_account (
	  id int not null auto_increment
	, username varchar(128) not null unique	-- tên đăng nhập
	, user int not null						-- Refer to hks_user
	, user_id int not null					-- Id of user
	, role int not null						-- Refer hks_role
	, role_id int not null             		-- Id of role
	, type int not null						-- 1: Hệ thống, 0: Ngoài hệ thống (FB, GMAIL, GITHUB, ...)
	, created datetime not null
	, createdby_username varchar(50) not null
	, lastmodified datetime
	, lastmodifiedby_username varchar(50)
	, primary key (id)
	, foreign key (user) references hks_user(id)
	, foreign key (role) references hks_role(id)
);

create table hks_role (
      id int not null  auto_increment
    , name nvarchar(64) not null
    , created datetime not null
    , createdby_username varchar(50) not null
    , lastmodified datetime
    , lastmodifiedby_username varchar(50)
    , primary key (id)
);

-- Bảng gán quyền cho account
create table hks_privileges(
	  id int not null auto_increment
	, role int not null					-- Refer to hks_role
	, role_id int not null  			-- Id of role
	, name nvarchar(80) not null		-- Action của quyền (gán quyền)
	, created datetime not null
	, createdby_username varchar(50) not null
	, lastmodified datetime
	, lastmodifiedby_username varchar(50)
	, primary key (id)
	, FOREIGN KEY (role) REFERENCES hks_role(id)
);

-- Bảng danh mục nhieu cap - Category
create table hks_cat (
	  id int not null auto_increment
	, name nvarchar(50) not null				-- Tên danh mục: Job, Co khi,  Sach, De tai, Article, Company profile  
	, parent_id int                      		-- Danh muc cha. Refer to id. Null co nghia la ko co cha - root
	, created datetime not null
	, createdby_username varchar(50) not null
	, lastmodified datetime
	, lastmodifiedby_username varchar(50)
	, primary key(id)
	-- , foreign key (parent_id) references hks_cat (id)
);

/**
 * configuration for workflow
 */
create table hks_workflow (
      id int not null auto_increment
    , seq_no int not null
    , class_name varchar(128) not null        -- Full qualified Class name of the entity. Ex: mksgroup.hks.entity.Item
    , current_status varchar(32)              -- None | Created | Approved | Rejected
    , next_status varchar(32)                 -- For a given role, this field determine what is next step of the object
	, next_object_type varchar(128)           -- cho biết đối tượng tiếp theo (nếu có) cần xử lý trong quy trình.
	, role varchar(32)                        -- refer to role.role. kết hợp với department_cd cho biết phòng nào, vai trò nào được quyền chuyển trang thái của loại đối tượng (object_type)
    , created datetime not null
    , createdby_username varchar(50) not null
    , lastmodified datetime
    , lastmodifiedby_username varchar(50)
    , primary key (id)
);

/**
 * quản lý trạng thái của một đối tượng cụ thể
 */
create table hks_status_object (
      id int not null auto_increment
    , class_name varchar(128) not null       -- Full qualified Class name of the entity. Ex: mksgroup.hks.entity.Item
    , object_id int not null       			 -- Refer to id of the entity. Ex: hks_items.id
	, previous_status varchar(32)            -- Trạng thái trước đó
	, current_status varchar(32)             -- Trạng thái sau khi chuyển: Created | Approved | Rejected
    , comment text                           -- comment when change previous status into current status
    , created datetime not null              -- Dựa vào thời gian gần nhất để biết trạng thái hiện của đối tượng (current_status)
    , createdby_username varchar(50) not null
    , lastmodified datetime
    , lastmodifiedby_username varchar(50)
    , primary key (id)
    , foreign key (object_id) references hks_items(id)
);

-- Bảng items
create table hks_items (
	  id int not null auto_increment
	, cat int not null		        	-- Tham khảo đến bảng hks_cat
	, cat_id int not null		    	-- id của cat
  	, image blob                     	-- main image
  	, title nvarchar(512) not null		-- Tiêu đề item
  	, short_desc nvarchar(1024)			-- Mô tả ngắn gọn về item
	, `desc` nvarchar(4000)          	-- nội dung đầy đủ item
	, status int not null            	-- Refer to status_object.id
	, status_id int                  	-- id của status
	, author varchar(128) not null   	-- account tac gia
	, author_username varchar(128) not null
	, views int not null             	-- lượt xem. Đếm sẵn từ table item_access
	, likes int not null             	-- lượt like. 
	, downloads int not null         	-- lượt download
	, comments int not null         	-- lượt comment
	, created datetime not null
	, createdby_username varchar(50) not null
	, lastmodified datetime
	, lastmodifiedby_username varchar(50)
	, primary key (id)
	, FOREIGN KEY (author) REFERENCES hks_user(username)
	, FOREIGN KEY (cat) REFERENCES hks_cat(id)
	, FOREIGN KEY (status) REFERENCES hks_status_object(id)
);

-- Bảng lưu version củ của items
create table hks_item_versions (
	  id int not null auto_increment
	, item_id int not null			-- Tham khảo đến bảng items
	, pre_version int				
	, cur_version int not null		
	, image blob                 	-- main image
  	, title nvarchar(512) not null
  	, short_desc nvarchar(1024)
	, descr nvarchar(4000) 		-- nội dung item
	, created datetime not null
	, createdby_username varchar(50) not null
	, lastmodified datetime
	, lastmodifiedby_username varchar(50)
	, primary key (id)
	, FOREIGN KEY (item_id) REFERENCES hks_items(id)
);

-- Luu cac hanh dong cua nguoi dung
create table hks_item_access (
	  id int not null auto_increment
	, item int not null,								-- Refer to hks_items
	, item_id int not null,								-- id của item
	, action int not null				   				-- 1: View; 2: Like: 3: Download; 4: Comments; 5: Share
	, finsh_action datetime,							-- Thời gian kết thúc action
 	, created datetime not null         				-- Time performs action
	, createdby_username varchar(128) not null 			-- person performs action
	, lastmodified datetime
	, lastmodifiedby_username varchar(50)
	, primary key (id)
	, foreign key (item) references hks_items(id)
	, foreign key (createdby_username) references hks_account(username)
);

-- Attached images or any files for item of the library.
create table hks_attach_file (
	  id int not null auto_increment
	, item int not null		-- Tham khảo đến bảng items
	, item_id int not null		-- id của item
	, content blob not null		-- Nội dung của file đính kèm
	, name nvarchar(512) 		-- Tên của file đính kèm, VD: image: name.png; pdf: name.pdf: video: name.avi
	, created datetime not null
	, createdby_username varchar(50) not null
	, lastmodified datetime
	, lastmodifiedby_username varchar(50)
	, primary key(id)
	, foreign key(item) references hks_items(id)
);

-- Bảng góp ý và phản hồi góp ý
create table hks_feedback (
	  id int not null auto_increment
	, account varchar(128) not null				-- Refer to account
	, account_name varchar(128) not null			-- Username người góp ý
	, content text not null						-- Nội dung góp ý
	-- , response_account_name varchar(128)		-- Username người trả lời  góp ý
	-- ,  response_content text					-- Nội dung trả lời
	, created datetime not null
	, createdby_username varchar(50) not null
	, lastmodified datetime
	, lastmodifiedby_username varchar(50)
	, primary key (id)
	-- ,  FOREIGN KEY (response_account_name) REFERENCES hks_account(username)
	, foreign key (account) references hks_account(username)
);

-- Bảng liên hệ và phản hồi liên hệ
create table hks_contact (
	  id int not null auto_increment
	, email varchar(128) not null 						-- người liên hệ	
    -- ,  status int not null	 						-- 0: Processing, 1: Finished
	, response_account_name varchar(128)  				-- người trả lời
	, content text not null								-- Nội dung liên hệ
	, created datetime not null
	, createdby_username varchar(50) not null
	, lastmodified datetime
	, lastmodifiedby_username varchar(50)
	, primary key (id)
	, FOREIGN KEY (response_account_name) REFERENCES hks_account(username)
);

create table hks_parameter_config(
	  id int not null auto_increment
	, datetime_format nvarchar(40)		-- Định dạng ngày, giờ
	, `precision` int					-- Định dạng độ chính xác, số lẻ
	, created datetime not null
	, createdby_username varchar(50) not null
	, lastmodified datetime
	, lastmodifiedby_username varchar(50)
	, primary key (id)
);

-- Bảng comments cho items
create table hks_comments (
	  id int not null auto_increment
	, action int not null						-- Refer to hks_item_access
	, action_id int not null					-- Id của action (4: comments)
	, content text not null						-- nội dung comments
	, created datetime not null
	, createdby_username varchar(50) not null
	, lastmodified datetime
	, lastmodifiedby_username varchar(50)
	, primary key (id)
	, FOREIGN KEY (action) REFERENCES hks_item_access(id)
);

-- Bảng trả lời comment
create table hks_response_comment(
	  id int not null auto_increment,
	, comment int not null 				-- Refer to hks_comments
	, comment_id int not null			
	, content text not null				-- Nội dụng trả lời
	, created datetime not null
	, createdby_username varchar(50) not null
	, lastmodified datetime
	, lastmodifiedby_username varchar(50)
	, primary key (id)
	, FOREIGN KEY (comment) REFERENCES hks_comments(id)
);

-- Bảng chat
create table hks_chat(
	  id int not null auto_increment
	, first_account varchar(128) not null			-- Người chat thứ nhất
	, second_account varchar(128) not null			-- Người chat thứ hai
	, created datetime not null
	, createdby_username varchar(50) not null
	, lastmodified datetime
	, lastmodifiedby_username varchar(50)
	, primary key (id)
	, FOREIGN KEY (first_name) REFERENCES hks_account(username)
	, FOREIGN KEY (second_name) REFERENCES hks_account(username)
);

-- Bảng chi tiết nội dung chat
create table hks_chat_line(
	  id int not null auto_increment
	, chat int not null						-- Tham khảo đến bảng chat
	, chat_id int not null					-- Id của người chat
	, line_content text not null				-- Nội dung dòng chat do người thực hiện
	, created datetime not null
	, createdby_username varchar(128) not null
	, lastmodified datetime
	, lastmodifiedby_username varchar(50)
	, primary key (id)
	, FOREIGN KEY (createdby_username) REFERENCES hks_account(username)
	, FOREIGN KEY (chat) REFERENCES hks_chat(id)
);

-- Bảng loại cơ cấu
create table hks_mechanism_type(
	  id int not null auto_increment
	, name nvarchar(50) not null unique,			-- Tên loại cơ cấu
	, created datetime not null
	, createdby_username varchar(50) not null		
	, lastmodified datetime
	, lastmodifiedby_username varchar(50)
	, primary key (id)
);

-- Bảng chi tiết cơ cấu
create table hks_mechanism(
	  id int not null auto_increment
	, type nvarchar(50) not null 					-- Tên loại cơ cấu 								
	, account_use varchar(128)						-- Người sử dụng
	, account_download varchar(128)					-- Người download
	, created datetime not null
	, createdby_username varchar(50) not null		
	, lastmodified datetime
	, lastmodifiedby_username varchar(50)
	, primary key (id)
	, foreign key (type) references hks_mechanism_type(name)
);

create table hks_mechanism_report (
	  id int not null auto_increment
	, type nvarchar(50) not null 					-- Refer hks_mechanism
	, uses int not null 							-- Thống kê lượt sử dụng
	, download int not null 						-- Thống kê lượt download
	, created datetime not null
	, createdby_username varchar(50) not null		
	, lastmodified datetime
	, lastmodifiedby_username varchar(50)
	, primary key (id)
	, foreign key (type) references hks_mechanism(type)
);

-- Bảng streaming
create table hks_streaming(
	  id int not null auto_increment
	, chat_id int not null						-- Tham khảo đến bảng chát (Streaming của cuộc chat nào)
	, end_time datetime not null				-- Thời gian kết thúc stream
	, created datetime not null
	, createdby_username varchar(50) not null
	, lastmodified datetime
	, lastmodifiedby_username varchar(50)
	, primary key (id)
	, FOREIGN key (chat_id) REFERENCES hks_chat(id)
);

-- Bảng chi tiết đăng việc (người tuyển dụng đăng)
create table hks_recruiting (
	  id int not null auto_increment
	, item_id int not null							-- Tham khảo đến bảng item
	, apply_name varchar(128)						-- Người apply
	, skill varchar(128) 							-- Ngôn ngữ lập trình
	, salary varchar(128)							-- Mức lương
	, job_position nvarchar(128)					-- Vị trí tuyển dụng
	, address_work nvarchar(128)					-- Nơi làm việc
	, created datetime not null
	, createdby_username varchar(50) not null
	, lastmodified datetime
	, lastmodifiedby_username varchar(50)
	, primary key (id)
	, foreign key (item_id) references hks_items(id)
	, foreign key (apply_name) references hks_account(username)
);

-- Bảng thông tin tìm việc
create table hks_seeking (
	  id int not null auto_increment
	, item_id int not null							-- Tham khảo đến bảng item
	, account_name varchar(128) not null
	, current_level nvarchar(128)					-- Cấp bậc hiện tại
	, expect_level nvarchar(123) not null 			-- Cấp bậc mong muốn
	, degree nvarchar(50) not null 					-- Bằng cấp
	, expect_city nvarchar(50) not null				-- Địa điểm mong muốn làm việc
	, created datetime not null
	, createdby_username varchar(50) not null
	, lastmodified datetime
	, lastmodifiedby_username varchar(50)
	, primary key (id)
	, foreign key (account_name) references hks_account(username)
	, foreign key (item_id) references hks_items(id)
);