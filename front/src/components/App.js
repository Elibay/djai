import React from 'react';
import '../css/App.css';

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      error: null, 
      value: "",
      to: "",
      id: "5e1afd9f725d340f00c16863"
    };
    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleChange = this.handleChange.bind(this);
  }
  handleChange(event) {
    this.setState({to: event.target.value})
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
  handleSubmit = event => {
    event.preventDefault()
    let json = JSON.stringify({value:this.state.to, id:this.state.id});
    fetch("http://localhost:8080", {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: json, 
    })
    .then(res => res.json())
    .then(
        window.location.reload(false)
    )
  };
  render() {
    const { error, value } = this.state;
    if (error) {
      return <div>Ошибка: {error.message}</div>;
    } else {
      return (
        <div className="divka">
          <div>
            <div className="wrap">
              <h1>{value}</h1>
              </div>
              <form onSubmit={this.handleSubmit} className="form__group" id="123">
                <input type="text" className="form__input" value={this.state.to} onChange={this.handleChange} />
              </form>
            <button className="button" onClick={this.handleSubmit}>
              Update
            </button>
          </div>
        </div>
      );
    }
  }
}

export default App;
