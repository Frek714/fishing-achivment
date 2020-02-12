import React, {Component} from 'react';
import './Homepage.scss';
import Navbar from "./navbar/Navbar";
import Footer from "./footer/Footer";
import PageContent from "./pageContent/PageContent";

class Homepage extends Component {
  constructor(props) {
    super(props);

    this.state = {

    };
  }

  render() {
    return (
      <>
        <div className="container">
          {/*navbar*/}
          <div className="row">
            <Navbar />
          </div>

          {/*infinite scroll*/}
          <div className="row">
            <PageContent />
          </div>

          {/*footer*/}
          <div className="row">
            <Footer />
          </div>
        </div>
      </>
    );
  }
}

export default Homepage;
