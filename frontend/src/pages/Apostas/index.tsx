import Footer from "componets/Footer";
import NavBar from "componets/NavBar";

const Aposta = () => {
    return (
        <>
            <NavBar />
            <div className="container">
                <div>
                    <h3>Todas as apostas</h3>
                </div>
                <hr />
                <div className="table-responsive">
                    <table className="table table-striped table-sm">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Jogo</th>
                                <th>E-mail do apostador</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>1</td>
                                <td>1 2 3 4 5 6</td>
                                <td>email1@email.com</td>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>1 2 3 4 5 6</td>
                                <td>email1@email.com</td>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>1 2 3 4 5 6</td>
                                <td>email1@email.com</td>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>1 2 3 4 5 6</td>
                                <td>email1@email.com</td>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>1 2 3 4 5 6</td>
                                <td>email1@email.com</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <Footer />
        </>
    );
}

export default Aposta;
