import React from 'react';
import '../css/App.css';

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      error: null, 
      value: ""
    }
  }
  componentDidMount() {
    fetch("http://localhost:8080/5e1afd9f725d340f00c16863/")
        .then(res => res.json())
        .then(
          (result) => {
            this.setState({
              value: result.value
            });
          },
          (error) => {
            this.setState({
              error
            });
          }
      )
  }
  render() {
    const { error, value } = this.state;
    if (error) {
      return <div>Ошибка: {error.message}</div>;
    } else {
      return (
        <div className="divka">
          <div>
            <div className="divka2">
              {value}
            </div>
            <button className="button">
              Update
            </button>
          </div>
        </div>
      );
    }
  }
}

export default App;
