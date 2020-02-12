import React, {Component} from 'react';
import './Footer.scss';
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faPlus, faUser} from "@fortawesome/free-solid-svg-icons";

class Footer extends Component {
  constructor(props) {
    super(props);

    this.state = {

    };
  }

  render() {
    return (
      <>
        <div className="container fixed-bottom">
          <div className="row footer-fish">
            <div className="col navigation-footer first">
              A
            </div>

            <div className="col navigation-footer">
              B
            </div>

            <div className="col navigation-footer">
              <button className="add-button"><FontAwesomeIcon icon={faPlus} /></button>
            </div>

            <div className="col navigation-footer">
              D
            </div>

            <div className="col navigation-footer">
              <button className="user-profile-button"><FontAwesomeIcon icon={faUser} /></button>
            </div>
          </div>
        </div>
      </>
    );
  }
}

export default Footer;
