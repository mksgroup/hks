drop table if exists hks_workflow;
drop table if exists status_object;
drop table if exists item_access;
drop table if exists hks_attach_file;
drop table if exists hks_items;
drop table if exists hks_cat;

create table hks_user (
      id int not null auto_increment
    , username varchar(50) not null unique    -- id của user
	, cd varchar(16) unique                   -- Mã nhân viên (theo nghiệp vụ)
    , email varchar(50)
    , firstname nvarchar(20)
    , lastname nvarchar(50)
    , avatar LONGBLOB						  -- avatar image of user
    , enabled boolean
    , created datetime not null
    , createdby_username varchar(50) not null
    , lastmodified datetime
    , lastmodifiedby_username varchar(50) 
    , canvas tinyint(1) default 1
    , side double
    , position_x double
    , position_y double
    , primary key (id)
);

create table hks_user_role (
      id int not null auto_increment
    , username varchar(50) unique not null
    , role_cd varchar(50)                    -- refer to role.cd
	, role_name nvarchar(64)
    , enabled boolean
    , group_id varchar(20) not null
    , created datetime not null
    , createdby_username varchar(50) not null
    , lastmodified datetime
    , lastmodifiedby_username varchar(50)
    , primary key (id)
);


create table hks_role (
      id int not null  auto_increment
    , cd varchar(32) not null unique         -- role code
    , name nvarchar(64)
	, role_type varchar(10) not null
	, role_type_name nvarchar(200) not null
    , enabled boolean
    , group_id varchar(20) not null
    , created datetime not null
    , createdby_username varchar(50) not null
    , lastmodified datetime
    , lastmodifiedby_username varchar(50)
    , primary key (id)
);

-- Bảng danh mục nhieu cap - Category
create table hks_cat (
	  id int not null auto_increment
	, name nvarchar(50) not null			-- Tên danh mục: Job, Co khi,  Sach, De tai, Article, Company profile  
	, parent_id int                      -- Danh muc cha. Refer to id. Null co nghia la ko co cha - root
	, created datetime not null
	, createdby_username varchar(50) not null
	, lastmodified datetime
	, lastmodifiedby_username varchar(50)
	, primary key(id)
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
);

-- Bảng items
create table hks_items (
	  id int not null auto_increment
	, cat int not null		        -- Tham khảo đến bảng hks_cat
	, cat_id int not null		    -- id của cat
  	, image blob                     -- main image
  	, title nvarchar(512) not null	-- Tiêu đề item
  	, short_desc nvarchar(1024)		-- Mô tả ngắn gọn về item
	, `desc` nvarchar(4000)          -- nội dung đầy đủ item
	, status int not null            -- Refer to status_object.id
	, status_id int                  -- id của status
	, author varchar(128) not null   -- account tac gia
	, author_username varchar(128) not null
	, views int not null             -- lượt xem. Đếm sẵn từ table item_access
	, likes int not null             -- lượt like. 
	, downloads int not null         -- lượt download
	, comments int not null         -- lượt comment
	, created datetime not null
	, createdby_username varchar(50) not null
	, lastmodified datetime
	, lastmodifiedby_username varchar(50)
	, primary key (id)
	, FOREIGN KEY (author) REFERENCES hks_user(username)
	, FOREIGN KEY (cat) REFERENCES hks_cat(id)
	, FOREIGN KEY (status) REFERENCES hks_status_object(id)
);

-- Luu cac hanh dong cua nguoi dung
create table hks_item_access (
	  id int not null auto_increment
	, action int not null				   -- 1: View; 2: Like: 3: Download; 4: Comments; 5: Share
 	, created datetime not null         -- person performs actoin
	, createdby_username varchar(50) not null
	, lastmodified datetime
	, lastmodifiedby_username varchar(50)
	, primary key (id)
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
