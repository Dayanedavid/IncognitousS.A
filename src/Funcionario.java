import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Funcionario {
    private String nome;
    private String endereco;
    private String email;
    private String setor;
    private LocalDate dataDeAdmissao;
    private LocalDate dataDeDemissao;
    private double salarioBase;
    private double bonificacao;

    public Funcionario(String nome, double salarioBase) {
        this.nome = nome;
        this.salarioBase = salarioBase;
        this.admitir();
    }

    public double getBonificacao() {
        return bonificacao;
    }

    public List<Ferias> getHistoricoFerias() {
        return historicoFerias;
    }

    public void setHistoricoFerias(List<Ferias> historicoFerias) {
        this.historicoFerias = historicoFerias;
    }

    private List<Ferias> historicoFerias;

    protected void setBonificacao(double bonificacao) {
        this.bonificacao = bonificacao;
    }

    public Funcionario(){
        this.bonificacao=0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public LocalDate getDataDeAdmissao() {
        return dataDeAdmissao;
    }

    public void setDataDeAdmissao(LocalDate dataDeAdmissao) {
        this.dataDeAdmissao = dataDeAdmissao;
    }

    public LocalDate getDataDeDemissao() {
        return dataDeDemissao;
    }

    public void setDataDeDemissao(LocalDate dataDeDemissao) {
        this.dataDeDemissao = dataDeDemissao;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public double consultarContraCheque() {
        return getSalarioBase();
    }

    public void solicitarFerias(LocalDate dataInicio, LocalDate dataFim) throws Exception {
        Ferias ferias = new Ferias();

        //pegou a data atual menos 11 meses é antes da data de admissao
        if(LocalDate.now().minusMonths(11).isBefore(this.dataDeAdmissao)){
            throw new Exception("Periodo de ferias invalido");
        }

        if(historicoFerias.size()>0){
        //para pegar o ultimo registro
        Ferias ultimasFerias= historicoFerias.get(historicoFerias.size()-1);
        if(ultimasFerias.getDataFim()==null){
            throw new Exception(this.nome+" já se encontra em período de férias");
        }

        if(LocalDate.now().minusMonths(4).isBefore(ultimasFerias.getDataFim())) {
            throw new Exception("Fora de período para solicitação de férias");
        }

        ferias.setDataInicio(dataInicio);
        ferias.setDataFim(dataFim);

        this.historicoFerias.add(ferias);
        }
    }

    public void trabalhar(LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim){

    }

    public void solicitarDemissao(){
        this.setDataDeDemissao(LocalDate.now());
    }

    public void solicitarAumento(double valor){

    }

    public void admitir(){
        setDataDeAdmissao(LocalDate.now());
    }

}
