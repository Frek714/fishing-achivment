import React, {Component} from 'react';
import './Navbar.scss';
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faSearch} from "@fortawesome/free-solid-svg-icons";

class Navbar extends Component {
  constructor(props) {
    super(props);

    this.state = {

    };
  }

  search = (event) => {

  };

  render() {
    return (
      <>
        <div className="container fixed-top">
          <div className="row navbar-fish">
            <div className="col-8 offset-2">
              <input type="text" defaultValue="" className="search-bar" onChange={this.search.bind(this)}/>
              <span className="search-button-box"><FontAwesomeIcon icon={faSearch}/></span>
            </div>n
          </div>
        </div>
      </>
    );
  }
}

export default Navbar;
