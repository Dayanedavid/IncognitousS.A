import java.time.LocalDate;

public class Supervisor extends FuncionarioPessoaFisica implements Demitidor {
    //final define uma constante
    private static final double BONIFICACAO= 1.08;

    @Override
    public double consultarContraCheque(){
        return super.consultarContraCheque()*BONIFICACAO;
    }

    @Override
    public void demitir(Funcionario funcionario) throws Exception {
        //
        if((funcionario instanceof Supervisor) || (funcionario instanceof Gerente)){
            throw new Exception("Você não pode demitir esse funcionário");
        } else {
            funcionario.setDataDeDemissao(LocalDate.now());
        }
    }

}
