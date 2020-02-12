import React, {Component} from 'react';
import './PageContent.scss';
import Box from "./box/Box";
import InfiniteScroll from "react-infinite-scroll-component";

class PageContent extends Component {
  constructor(props) {
    super(props);

    this.state = {
      titoli: ["titolo 1", "titolo 2", "titolo 3", "titolo 4"]
    };
  }

  fetchMoreData = () => {
    // a fake async api call like which sends
    // 20 more records in 1.5 secs
    setTimeout(() => {
      const titoli = [...this.state.titoli];
      const newTtitoli = titoli.concat(titoli);
      this.setState({
        titoli: newTtitoli
        // titoli: this.state.titoli.concat(Array.from(["titolo 1", "titolo 2", "titolo 3", "titolo 4"]))
      });
    }, 500);
  };

  render() {
    return (
      <>
        <div className="page-content-box">
          <div className="container">
            <div className="page-content">
              <InfiniteScroll
                dataLength={this.state.titoli.length}
                next={this.fetchMoreData}
                hasMore={true}
                loader={<h4>Loading...</h4>}>
                {this.state.titoli.map((titolo, index) => (
                  <Box titolo={titolo} key={index}/>
                ))}
              </InfiniteScroll>
            </div>
          </div>
        </div>
      </>
    );
  }
}

export default PageContent;
