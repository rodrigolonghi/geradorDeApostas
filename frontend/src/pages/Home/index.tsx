import Footer from "componets/Footer";
import NavBar from "componets/NavBar";

function Home() {
    return (
      <>
        <NavBar />
        <div className="container">
          <div className="jumbotron">
            <h1 className="display-4">Gerador de apostas</h1>
            <p className="lead py-3">Cadestre seu e-mail e gere jogos para a Loteria</p>
            <hr />
            <p className="py-4">Esta aplicação consiste em gerar jogos aleatórios de 6 números para apostar na loteria.
              <br/>
              Todos os jogos são vinculados a um e-mail cadastrado.
              <br/>
              Nenhum e-mail poderá receber duas vezes o mesmo jogo.
            </p>
          </div>
        </div>
        <Footer />
      </>
    );
  }
  
  export default Home;
  