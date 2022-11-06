public class Cadastro {
  public Cadastro vagas[] = new Cadastro[30];
  public Automoveis automovel[];
  public Cliente cliente[];


  public Cadastro(Cadastro[] vagas, Automoveis[] automovel, Cliente[] cliente) {
    this.vagas = vagas;
    this.automovel = automovel;
    this.cliente = cliente;
  }

  public Cadastro() {
  
  }


}
