import Footer from "componets/Footer";
import NavBar from "componets/NavBar";

const Apostadores = () => {
    return (
        <>
            <NavBar />
            <div className="container">
                <div>
                    <h3>Todos os apostadores</h3>
                </div>
                <hr />
                <div className="table-responsive">
                    <table className="table table-striped table-sm">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>E-mail</th>
                                <th>Número de apostas</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>1</td>
                                <td>email1@email.com</td>
                                <td>0</td>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>email1@email.com</td>
                                <td>0</td>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>email1@email.com</td>
                                <td>0</td>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>email1@email.com</td>
                                <td>0</td>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>email1@email.com</td>
                                <td>0</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <Footer />
        </>
    );
}

export default Apostadores;
