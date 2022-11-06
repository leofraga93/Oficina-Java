public class Cliente extends Automoveis{
  private String nome, telefone, email;
  private Servico service;
  
  public Cliente(String nome, String telefone, String email, Servico service) {
    this.nome = nome;
    this.telefone = telefone;
    this.email = email;
    this.service = service;
  }

  public Cliente(String nome, String telefone, String email) {
    this.nome = nome;
    this.telefone = telefone;
    this.email = email;
    this.service = new Servico();
  }

  public Cliente() {
    this.service = new Servico();
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Servico getService() {
    return service;
  }

  public void setService(Servico service) {
    this.service = service;
  }

  @Override
  public String toString() {
    return "Cliente [nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", service=" + service + "]";
  }

  
}
