import javax.swing.JOptionPane;

public class App {

    //cadastro de carros em uma oficina para 30 vagas.
    final int TAM = 30;
    int vaga, escolha;
    String string;
    Cliente cliente[] = new Cliente[TAM];
    Servico service = new Servico();
   
    //vagas disponivéis que deverá ser preenchida a cada carro (marca, modelo, placa, serviço, valor do serviço) e os metodos para entrada de carro, serviço realizado e liberação de carro.
    public void entrada(){
        vaga = Integer.parseInt(JOptionPane.showInputDialog("Selecione a sua Vaga (1 - 30) "));
        if (vaga<0 || vaga>=TAM){
            JOptionPane.showMessageDialog(null, "Favor verifique! Vaga não disponível");
            return;
        }
        this.cliente[vaga]=new Cliente();
        this.cliente[vaga].setNome(JOptionPane.showInputDialog("Nome do Cliente"));
        this.cliente[vaga].setTelefone(JOptionPane.showInputDialog("Telefone do Cliente"));
        this.cliente[vaga].setEmail(JOptionPane.showInputDialog("Email do Cliente"));
        this.cliente[vaga].setMarca(JOptionPane.showInputDialog("Marca do automovel"));
        this.cliente[vaga].setModelo(JOptionPane.showInputDialog("Modelo do automovel"));
        this.cliente[vaga].setPlaca(JOptionPane.showInputDialog("Placa do automovel"));
        listarServicos();
        //passando o serviço do cliente
        this.cliente[vaga].setService(service);

        escolha = this.cliente[vaga].getService().getTipo();
        switch (escolha) {
            case 1: string = " 1 - Fazer revisão\n"
            +"Valor cobrado: "+ this.cliente[vaga].getService().getValor();
            break;
            case 2: string = "2 - Escolher troca de óleo\n"
            +"Valor cobrado: "+ this.cliente[vaga].getService().getValor();
            break;
            case 3: string = "3 - Alinhar e balacear\n"
            +"Valor cobrado: "+ this.cliente[vaga].getService().getValor();
            break;
            case 4: string = "4 - Troca de filtros\n"
            +"Valor cobrado: "+ this.cliente[vaga].getService().getValor();
            break;
            case 5: string = "5 - Lavagem de motor\n"
            +"Valor cobrado: "+ this.cliente[vaga].getService().getValor();
            break;
            default: string = "0 - Nenhuma das opções\n"
            +"Valor cobrado: "+ this.cliente[vaga].getService().getValor();                
            break;
        }
        JOptionPane.showMessageDialog(null, "Cliente "+this.cliente[vaga].getNome()+" Alocado na Vaga: "+vaga +" serviço selecionado: " +string +".");
    }

    public void listarServicos() {
        this.service.listarTipo();
    }

    //(antes da liberação deverá mostrar a fatura do carro com: os dados do carro, serviço e valor);
    public void liberar(){
        vaga = Integer.parseInt(JOptionPane.showInputDialog("Qual a Vaga alocada"));
        if (vaga<0 || vaga>=TAM){
            JOptionPane.showMessageDialog(null, "Favor verifique! vaga não cadastrada");
            return;
        }
        if (this.cliente[vaga]!=null){
            int escolha = this.cliente[vaga].getService().getTipo();
            String string = "Fatura do Cliente "+ this.cliente[vaga].getNome()+":\n"
            +"Email de recebimento desta fatura: "+ this.cliente[vaga].getEmail()+"\n"
            +"Serviço selecionado: ";
            
            switch (escolha) {
                case 1: JOptionPane.showMessageDialog(null, string +"1 - Fazer revisão\n"
                +"Valor cobrado: "+ this.cliente[vaga].getService().getValor());
                break;
                case 2: JOptionPane.showMessageDialog(null, string +"2 - Escolher troca de óleo\n"
                +"Valor cobrado: "+ this.cliente[vaga].getService().getValor());
                break;
                case 3: JOptionPane.showMessageDialog(null, string +"3 - Alinhar e balacear\n"
                +"Valor cobrado: "+ this.cliente[vaga].getService().getValor());
                break;
                case 4: JOptionPane.showMessageDialog(null, string +"4 - Troca de filtros\n"
                +"Valor cobrado: "+ this.cliente[vaga].getService().getValor());
                break;
                case 5: JOptionPane.showMessageDialog(null, string +"5 - Lavagem de motor\n"
                +"Valor cobrado: "+ this.cliente[vaga].getService().getValor());
                default: JOptionPane.showMessageDialog(null, string +"0 - Nenhuma das opções\n"
                +"Valor cobrado: "+ this.cliente[vaga].getService().getValor());                 
                break;
            }
            this.cliente[vaga]=null;
        } 
        else JOptionPane.showMessageDialog(null, "Favor verifique! vaga "+vaga+" não tem cadastro");
    }

    public void listarCarros(){
        String dados="";
        for(int x=0; x < TAM ; x++){
            if (cliente[x]==null) continue;
            dados +="Vaga "+x+" - "+this.cliente[x].getNome()+" - "+this.cliente[x].getTelefone()+" - "
                    + ""+this.cliente[x].getEmail()+"\n";
        }
        JOptionPane.showMessageDialog(null, dados); 
    }

    public void listarVagas(){
        String vagas="";
        int y=1;
        for(int x=0; x < TAM ; x++){
            if (cliente[x]!=null){ vagas +="[ "+cliente[x].getNome()+"] - "; continue; }
            vagas +="["+x+"] - ";
            y++;
            if (y>10){vagas+="\n";y=1;} 
        }
        JOptionPane.showMessageDialog(null, vagas);
    }

    public static void main(String[] args) {
        // Escreva um programa em Linguagem Java que trabalhe com conceitos POO (classe, atributos e métodos)
        App oficina = new App();
        
        /*Parte do APP
        * O sistema deverá ter opções de menu para:
        1 - Fazer o entrada de carro;
        2 - Lançar o serviço e valor do serviço no carro cadastrado;
        3 - Liberação do carro 
        4 - Listar carros na oficina;
        5 - Listar vagas na oficina.
        O Sistema encerra quando a opção 0 (zero) for digitada
        */
        int menu;
        do {
            menu = Integer.parseInt(JOptionPane.showInputDialog
            ("Oficna Fraga's\n"
            + "1 - Fazer entrada\n"
            + "2 - Escolher serviço\n"//chamar o método da classe serviço
            + "3 - Liberar carro\n"
            + "4 - Listar carros cadastrados\n"
            + "5 - Listar vagas disponíveis\n"
            + "0 - Sair do Sistema"));
            switch (menu) {
                case 1: oficina.entrada(); break;
                case 2: oficina.listarServicos(); break;
                case 3: oficina.liberar(); break;
                case 4: oficina.listarCarros(); break;
                case 5: oficina.listarVagas(); break;
                case 0: JOptionPane.showMessageDialog(null, "Fim do Sistema"); break;
                default: JOptionPane.showMessageDialog(null,"Opção Invalida");
            }
        } while (menu!=0);
        
        
        System.out.println("Colé, Mundo!");
    }
}
