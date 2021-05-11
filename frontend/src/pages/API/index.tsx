import Footer from "componets/Footer";
import NavBar from "componets/NavBar";

const email = '{email}';
const host = '{{host}}';

const API = () => {
    return (
        <>
            <NavBar />
            <div className="container">
                <div>
                    <h3>Acessando o endpoint</h3>
                </div>
                <hr/>
                <div>
                    Para o deploy do back-end desta aplicação foi utilizado o <a href="https://www.heroku.com">Heroku</a>.
                    <br/><br/>
                    Todos os endpoints podem ser acessado usando como host o endereço: "https://gerador-de-apostas.herokuapp.com".
                    <br/><br/>
                    O endpoint "{host}/apostadores" pode ser usado para cadastrar um novo apostador e obter uma lista de todos
                    os apostadores através dos métodos PATCH e GET, respectivamente.
                    <br/><br/>
                    O endpoint "{host}/apostadores/{email}" pode ser usado para atualizar o email, obter todas as apostas e
                    excluir o apostador especificado, respectivamente através dos métodos PATCH, GET e DELETE.
                    <br/><br/>
                    Por fim, o endpoint "{host}/apostadores/{email}/nova-aposta" pode ser usado para gerar uma nova
                    aposta para o email especificado.
                </div>
            </div>
            <Footer />
        </>
    );
}

export default API;
