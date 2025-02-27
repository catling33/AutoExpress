import React from "react";
import {BrowserRouter as Router} from "react-router-dom";
import {Layout} from 'antd';

import Top from './components/Top';
import Bottom from './components/Bottom';
import Main from './components/Main';

const {Header, Footer, Content} = Layout;

class App extends React.Component {
    state = {
      isLoggedIn: false,
    }

    setLoggedIn = (status) => {
        this.setState({isLoggedIn: status}); // true or false;
    }

    render() {
        return (
            <Router>
                <Layout>
                    <Header className="App-header">
                        <Top isLoggedIn={this.state.isLoggedIn} setLoggedIn={this.setLoggedIn}/>
                    </Header>

                    <Content className="App-content">
                        <Main isLoggedIn={this.state.isLoggedIn} setLoggedIn={this.setLoggedIn}/>
                    </Content>

                    <Footer className="App-footer">
                        <Bottom />
                    </Footer>
                </Layout>
            </Router>
        )
    };


}

/*
function App()
    {
        return (
            <div className="App">
                <header className="App-header">
                    <img src={logo} className="App-logo" alt="logo"/>
                    <p>
                        Edit <code>src/App.js</code> and save to reload.
                    </p>
                    <a
                        className="App-link"
                        href="https://reactjs.org"
                        target="_blank"
                        rel="noopener noreferrer"
                    >
                        Learn React
                    </a>
                </header>
            </div>
        );
    }
*/

export default App;
