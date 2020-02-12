import React, {Component} from 'react';
import './Box.scss';

class Box extends Component {
  constructor(props) {
    super(props);

    this.state = {

    };
  }

  render() {
    return (
      <>
        <div className="card mb-3 content-box">
          <svg className="bd-placeholder-img card-img-top rect" width="100%" height="180" xmlns="http://www.w3.org/2000/svg"
               preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: Image cap">
            <title>Placeholder</title>
            <text x="50%" y="50%" fill="#dee2e6" dy=".3em">Image cap</text>
          </svg>
            <div className="card-body">
              <h5 className="card-title">{this.props.titolo}</h5>
              <p className="card-text">This is a wider card with supporting text below as a natural lead-in to
                additional content. This content is a little bit longer.</p>
              <p className="card-text"><small className="text-muted">Last updated 3 mins ago</small></p>
            </div>
        </div>
      </>
    );
  }
}

export default Box;
