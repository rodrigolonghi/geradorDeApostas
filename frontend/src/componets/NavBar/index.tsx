function NavBar() {
    return (
        <nav className="navbar navbar-expand-md navbar-dark bg-dark mb-4">
            <div className="container-fluid">
                <a className="navbar-brand" href="/">Gerador de apostas</a>
                <div className="collapse navbar-collapse" id="navbarCollapse">
                    <ul className="navbar-nav me-auto mb-2 mb-md-0">
                        <li className="nav-item">
                            <a className="nav-link" href="/apostadores">Apostadores</a>
                        </li>
                        <li className="nav-item">
                            <a className="nav-link" href="/apostas">Apostas</a>
                        </li>
                        <li className="nav-item">
                            <a className="nav-link" href="/api">API</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    );
}

export default NavBar;
