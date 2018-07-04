import React, {Component} from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View,
  TextInput,
  Keyboard,
  Alert,
  Image,
  TouchableOpacity,
  FlatList,
} from 'react-native';
import messageData from '../data/messageData';

class FlatListItem extends Component {
  render(){
    return(
        <View style={{backgroundColor:this.props.item.type %2==0 ?'lightgrey':'#005ce6',
        borderRadius:20,
        justifyContent: 'center',
        marginTop: 5,

        alignSelf:this.props.item.type %2==0 ?'flex-start' : 'flex-end',
        marginLeft:this.props.item.type %2==0 ?10:150,
        marginRight:this.props.item.type %2==0 ?150:10}}>
          <Text style={{
            fontFamily: 'Cochin',
          padding: 10,
          fontSize: 17,
          color :this.props.item.type %2==0 ?'black':'white'}}>{this.props.item.content}</Text>
        </View>
    );
  }
}


export default class ChatScreen  extends Component{
   textInputRef;
  constructor(props) {
      super(props);

      this.state = {
      deleteRowkey: null,
      message: ''
    }
  }
  refreshFlatList = (activeKey) => {
      this.setState((prevState) => {
        return{
         deleteRowkey: activeKey,
        };
      });
      setTimeout(() => this.refs.flatList.scrollToEnd(), 10)

    }
  _onPress = () => {
    const newKey = this.generateKey(24);
    const newContent = this.state.message;
    if(newContent==0 ){
          return;
        }
    const newMessage = {
      key: newKey,
      content: newContent,
      type : 1
    }
    messageData.push(newMessage);
    this.refreshFlatList(newKey);
    this.textInputRef.clear();
    this.setState(
      (previousState) => {
        return {
          message: ''
        };
      }
    );
  }
  _onPress1 = () => {
    const newKey = this.generateKey(24);
    const newContent = this.state.message;
    if(newContent==0 ){
          return;
        }
    const newMessage = {
      key: newKey,
      content: newContent,
      type : 2
    }
    messageData.push(newMessage);
    this.refreshFlatList(newKey);
    this.textInputRef.clear();
    this.setState(
      (previousState) => {
        return {
          message: ''
        };
      }
    );
  }

  generateKey = (numberOfCharacter) => {
    return require('random-string')({lenght: numberOfCharacter});
  }
  render(){
    return(
      <View style = {
        {
          marginTop: 50,
          flex: 1,
          flexDirection: 'column',
          justifyContent: 'flex-start',
        }
      }>


        <View style=
        {
          {
            backgroundColor:'#0040ff',
            height: 60,
            borderColor: 'gray',
            borderWidth: 2,
            flexDirection:'row'

          }
        }>
            <Image source = {require('../image/anhdaidien.jpg')}
                style={ {width: 55, height: 55 ,borderRadius:200,marginLeft:10} }>
            </Image>
            <View style={{
                flexDirection:'column'
              }}>
                <Text style={{marginTop: 8, fontSize: 20,color:'white',marginLeft:20}}>
                  Technician
                </Text>
                <Text style={{marginTop: 0, fontSize: 14,color:'white',marginLeft:27}}>
                  Active
                </Text>
              </View>
              <Image source = {require('../image/call.png')}
                  style={ {width: 35, height: 35 ,borderRadius:200,marginLeft:50,marginTop:12} }>
              </Image>
              <Image source = {require('../image/video.png')}
                  style={ {width: 35, height: 35 ,borderRadius:200,marginLeft:15,marginTop:12} }>
              </Image>
              <Image source = {require('../image/setting.png')}
                  style={ {width: 35, height: 35 ,borderRadius:200,marginLeft:40,marginTop:12} }>
              </Image>
        </View>



        <View style = {{flex: 1, flexDirection: 'column', justifyContent: 'flex-end'}}>
          <FlatList style={{flex:1}}
          ref = {"flatList"}
            contentContainerStyle = {styles.conversation}
            data = {messageData}
            renderItem = {({item, index}) => {
              return(
                <FlatListItem item = {item} index = {index} parentFlatList = {this}>

                </FlatListItem>);
            }}>
          </FlatList>
        </View>



        <View style=
        {
          {
            height: 60,
            marginBottom: 20,
            flexDirection: 'row',
            justifyContent: 'flex-end',
            alignItems: 'center'
          }
        }>
          <TextInput style = {
            {
              flex: 5,
              marginLeft: 20,
              marginRight: 20,
              padding: 10,
              height: 40,
              borderColor: 'blue',
              borderWidth: 2
            }
          }
          ref={comp => { this.textInputRef = comp; }}
          placeholder = 'Enter your message'
          underlineColorAndroid='transparent'
          multiline={true}
          returnKeyType = 'send'
          onSubmitEditing={Keyboard.dismiss}
          onChangeText = {
            (text) => {

              this.setState(
                (previousState) => {
                  return {
                    message: text
                  };
                }
              );
            }
          }
          //value = {this.state.message}
          >
          </TextInput>
          <View style={{flex: 1, flexDirection: 'column', justifyContent: 'flex-start'}}>
            <TouchableOpacity onPress = {this._onPress} >
              <Image source = {require('../image/383448-200.png')}
                style={ {width: 40, height: 40} }>
              </Image>
            </TouchableOpacity>
          </View>


          <View style={{flex: 1, flexDirection: 'column', justifyContent: 'flex-start'}}>
            <TouchableOpacity onPress = {this._onPress1} >
              <Image source = {require('../image/383448-201.png')}
                style={ {width: 40, height: 40} }>
              </Image>
            </TouchableOpacity>
          </View>



        </View>





      </View>

    );
  }
}



const styles = StyleSheet.create({
  conversation: {
  //  marginLeft:150,
  //  marginRight: 10,
    flexDirection: 'column',
    //alignItems: 'flex-start',//start right
    justifyContent: 'flex-end',//start
    flexGrow: 1
  },
  flatListItem: {
    fontFamily: 'Cochin',
    color: 'white',
    padding: 10,
    fontSize: 17
  }
});
