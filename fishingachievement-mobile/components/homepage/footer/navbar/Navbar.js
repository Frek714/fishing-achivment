import React, {Component} from 'react';
import {StyleSheet, Text, TouchableHighlight, TouchableOpacity, View} from 'react-native';
import {Ionicons} from "@expo/vector-icons";

class Navbar extends Component {

  pressPlus = () => {

  };

  pressProfile = () => {

  };

  render() {
    return (
      <>
        <View style={style.containerNavbar}>
          <View style={style.buttonContainerNavbar}>
            <Text>A</Text>
          </View>

          <View style={style.buttonContainerNavbar}>
            <Text>B</Text>
          </View>

          <View style={style.buttonContainerNavbar}>
            <TouchableOpacity onPress={this.pressPlus}>
              <View><Ionicons name="ios-add" size={35} style={style.plusIcon}/></View>
            </TouchableOpacity>
          </View>

          <View style={style.buttonContainerNavbar}>
            <Text>D</Text>
          </View>

          <View style={style.buttonContainerNavbar}>
            <TouchableOpacity onPress={this.pressProfile}>
              <Ionicons name="md-person" size={32} style={style.profileIcon}/>
            </TouchableOpacity>
          </View>
        </View>
      </>
    );
  }
}

const style = StyleSheet.create({
  containerNavbar: {
    flexDirection: "row",
    justifyContent: "flex-start",
    backgroundColor: "orange",
  },
  buttonContainerNavbar: {
    flex: 1,
    alignItems: "center",
    height: 100,
    paddingTop: 10,
    borderTopWidth: 2
  },
  plusIcon: {},
  profileIcon: {}
});

export default Navbar;
