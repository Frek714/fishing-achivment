import React, {Component} from 'react';
import {StyleSheet, TextInput, View} from 'react-native';
import {Ionicons} from '@expo/vector-icons';

class SearchBar extends Component {
  constructor(props) {
    super(props);

    this.state = {
      searchText: ""
    };
  }

  search = (text) => {
    this.setState({
      searchText: text
    });
  };

  render() {
    return (
      <>
        <View style={style.containerSearchBar}>
          <TextInput style={style.searchBar} placeholder="Search..." value={this.state.searchText}
                     onChange={(text) => this.search(text)}/>
          <View style={style.searchIcon}><Ionicons name="ios-search" size={23}/></View>
        </View>
      </>
    );
  }
}

const style = StyleSheet.create({
  containerSearchBar: {
    flexDirection: "row",
    justifyContent: "center",
    marginBottom: 10,
    // alignItems: "stretch",
  },
  searchBar: {
    width: 300,
    height: 30,
    borderWidth: 1,
    borderColor: "#000",
    borderRadius: 5,
  },
  searchIcon: {
    marginLeft: -25,
    marginTop: 3
  }
});

export default SearchBar;
