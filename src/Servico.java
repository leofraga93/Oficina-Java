import javax.swing.JOptionPane;

public class Servico {
  private int tipo;
  private float valor;

  public void listarTipo(){
    int servicoEscolhido;
    servicoEscolhido = Integer.parseInt(JOptionPane.showInputDialog( 
            "Escolha o seu serviço\n"
            + "1 - Fazer revisão\n"
            + "2 - Escolher troca de óleo\n"
            + "3 - Alinhar e balacear\n"
            + "4 - Troca de filtros\n"
            + "5 - Lavagem de motor\n"
            + "0 - Nenhuma das opções"));
    setTipo(servicoEscolhido);
  }

  public int getTipo() {
    return tipo;
  }

  public void setTipo(int tipo) {
    switch (tipo) {
      case 1:
        JOptionPane.showMessageDialog(null,"Revisão");
        this.tipo = tipo;
        this.valor = 90;
        break;
      case 2:
        JOptionPane.showMessageDialog(null, "Troca de óleo");
        this.tipo = tipo;
        this.valor = 60;
        break;
      case 3:
        JOptionPane.showMessageDialog(null, "Alinhamento e balanceamento");
        this.tipo = tipo; 
        this.valor = 25;
        break;
      case 4:
        JOptionPane.showMessageDialog(null, "Troca de filtros");
        this.tipo = tipo; 
        this.valor = 40;
        break;
      case 5:
        JOptionPane.showMessageDialog(null, "Lavagem de motor");
        this.tipo = tipo; 
        this.valor = 120;
        break;
      case 0:
        JOptionPane.showMessageDialog(null, "Nenhuma opção selecionada");
        break;
      default:
        JOptionPane.showMessageDialog(null, "Opção inválida, tente novamente."); 
        break;
    }
  }

  public float getValor() {
    return valor;
  }
  public void setValor(float valor) {
    this.valor = valor;
  }

  
}
