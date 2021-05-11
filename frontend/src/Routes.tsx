import API from 'pages/API';
import Aposta from 'pages/Apostas';
import Apostadores from 'pages/Apostadores';
import Home from 'pages/Home';
import { BrowserRouter, Route, Switch } from 'react-router-dom';

const Routes = () => {
    return (
        <BrowserRouter>
            <Switch>
                <Route path="/" exact>
                    <Home />
                </Route>
                <Route path="/apostadores">
                    <Apostadores />
                </Route>
                <Route path="/apostas">
                    <Aposta />
                </Route>
                <Route path="/api">
                    <API />
                </Route>
            </Switch>
        </BrowserRouter>
    );
}

export default Routes;
