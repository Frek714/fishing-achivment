import React, {Component} from 'react';
import {Keyboard, StyleSheet, View, TouchableWithoutFeedback} from 'react-native';
import SearchBar from "./header/searchbar/SearchBar";
import Navbar from "./footer/navbar/Navbar";
import PageContent from "./pageContent/PageContent";

class Homepage extends Component {

  render() {
    return (
      <>
        <TouchableWithoutFeedback onPress={Keyboard.dismiss} accessible={false}>
          <View style={style.container}>
            <View style={style.headerContainer}>
              <SearchBar/>
            </View>
            <View style={style.pageContentContainer}>
              <PageContent />
            </View>
            <View style={style.footerContainer}>
              <Navbar />
            </View>
          </View>
        </TouchableWithoutFeedback>
      </>
    );
  }
}

const style = StyleSheet.create({
  container: {
    flex: 1,
    flexDirection: "column",
    alignItems: "stretch"
  },
  headerContainer: {
    flex: 1,
    borderWidth: 1,
    borderColor: "red",
    justifyContent: "flex-end"
  },
  pageContentContainer: {
    flex: 7,
    borderWidth: 1,
    borderColor: "purple"
  },
  footerContainer: {
    flex: 1,
    borderWidth: 1,
    borderColor: "dodgerblue"
  }
});

export default Homepage;
