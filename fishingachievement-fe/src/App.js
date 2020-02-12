import React from 'react';
import './App.css';
import Homepage from "./components/homepage/Homepage";
import {library} from "@fortawesome/fontawesome-svg-core";
import {faSearch} from "@fortawesome/free-solid-svg-icons";

library.add(faSearch);

function App() {
  return (
    <div className="App">
      <Homepage />
    </div>
  );
}

export default App;
