import java.util.*;

abstract class Concessionaria{
    private int id;
    private String marca;
    private String modelo;
    private String cor;
    private int ano;
    private double preco;
    private String categoria;
    public Concessionaria(int id, String marca, String modelo, String cor, int ano,double preco,String categoria) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
        this.preco = preco;
        this.categoria = categoria;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "ID:"+getId()  +"\n" +"Marca:" + getMarca() + "\n" +"Modelo:"+getModelo() +"\n" +"Cor:"+getCor() +"\n" +"Ano:"+getAno()+"\n" +"Preço:"+getPreco()+"\n" +"Categória:"+getCategoria();
    }
    
    abstract double CalcularTotal();
  
}
class Casual extends Concessionaria{

    public Casual(int id, String marca, String modelo, String cor, int ano,double preco,String categoria){
        super(id, marca, modelo, cor, ano, preco,categoria);
    }

    @Override
    double CalcularTotal() {
        
        return getPreco() * 0.15;
    }

    
}

class Esportivo extends Concessionaria{
    public Esportivo(int id, String marca, String modelo, String cor, int ano,double preco,String categoria){
        super(id, marca, modelo, cor, ano, preco, categoria);
    }

     @Override
    double CalcularTotal() {
        
        return getPreco() * 0.25;
    }
}

class Luxo extends Concessionaria{
    public Luxo(int id, String marca, String modelo, String cor, int ano,double preco,String categoria){
        super(id, marca, modelo, cor, ano, preco, categoria);
    }

     @Override
    double CalcularTotal() {
        
        return getPreco() * 0.55;
    }
}
@FunctionalInterface
interface AplicarDesconto{
    double desconto();
}

class Cliente{
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private  int idade;
    public Cliente(String nome, String cpf, String email, String telefone, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.idade = idade;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

   
}

public class Main {
    static Map<String ,List<Concessionaria>> carros = new HashMap<>();
    static Map<String , Cliente> informacaoDoCliente = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      
        int op;
        do {
            System.out.println("------Menu--------");
            System.out.println("1-Cadastrar");
            System.out.println("2-Filtrar por Ano do carro");
            System.out.println("3-Listar Todos os carros");
            System.out.println("4-Remover Carro pelo ID");
            System.out.println("5-Atualizar Cor pelo CPF");
            System.out.println("6-Sair do Sistema");
            System.out.print("Escolha una Opção:");
             op = sc.nextInt();
            switch (op) {
                case 1->Cadastrar(sc);
                case 2->Filtrar(sc);
                case 3->ListarTudo(sc);
                 case 4->Remover(sc);
               case 5->Atualizar(sc);
                case 6->System.out.println("Programa Encerrado..");
                default->System.out.println("Opção Inválida. Escolha a função de 1 a 6");
            }
        } while (op!=6);
        sc.close();
    }
    public static void Cadastrar(Scanner sc){
        sc.nextLine();
        System.out.println("=========Informações do Cliente=============");
        System.out.println("1-Digite o Nome do cliente:");
        String nome = sc.nextLine();
        System.out.println("Digite o CPF do cliente:");
        String cpf = sc.nextLine();
        System.out.println("Digite o E-mail do cliente:");
        String email = sc.nextLine();
        if(!email.contains("@gmail.com")){
            System.out.println("E-mail Inválido.  Digite um e-mail com @gmail.com");
            return;
        }
        System.out.println("Digite o Telefone do cliente:");
        String Telefone = sc.nextLine();
        System.out.println("Digite a Idade do cliente:");
        int idade = sc.nextInt();
        Cliente cliente = new Cliente(nome, cpf, email, Telefone, idade);
        informacaoDoCliente.put(cpf, cliente);
        System.out.println("========================================================");
        
        System.out.println("================Informações do Carro=================");
        System.out.println("Digite o ID do Carro:");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite a Marca:");
        String marca = sc.nextLine();
        System.out.println("Digite o Modelo:");
        String modelo = sc.nextLine();
        System.out.println("Digite a Cor:");
        String Cor = sc.nextLine();
        System.out.println("Digite o Ano:");
        int ano = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite o Preço:");
        double preco = sc.nextDouble();
        sc.nextLine();
        System.out.println("Digite a Categoria (casual,esportivo,luxo):");
        String categoria = sc.nextLine();

        switch (categoria.toLowerCase()) {
            case "casual":
                Concessionaria casual = new Casual(id, marca, modelo, Cor, ano, preco, categoria);
                carros.putIfAbsent(cpf, new ArrayList<>());
                carros.get(cpf).add(casual);
                break;
            case "esportivo":
                Concessionaria esportivo = new Esportivo(id, marca, modelo, Cor, ano, preco, categoria);
                carros.putIfAbsent(cpf, new ArrayList<>());
                carros.get(cpf).add(esportivo);
                break;
                
            case "luxo":
                 Concessionaria luxo = new Esportivo(id, marca, modelo, Cor, ano, preco, categoria);
                carros.putIfAbsent(cpf, new ArrayList<>());
                carros.get(cpf).add(luxo);
                break;

            default: 
                System.out.println("Opção Inválida. Escolha entre (casual,esportivo,luxo)");
                return;
        }
        System.out.println("Informações cadastradas com sucesso!! ");
         System.out.println("========================================================");
    }

    public static void Filtrar(Scanner sc){
         sc.nextLine();
        if(carros.isEmpty()){
            System.out.println("Nenhuma informção cadastrada!!");
            return;
        }
        System.out.println("Digite o CPF do cliente:");
        String cpf = sc.nextLine();

        List<Concessionaria> TiposdeCarros = carros.get(cpf);
        if(TiposdeCarros == null){
            System.out.println("Nenhum carro associado a esse CPF");
        }

       else if(TiposdeCarros !=null){
         System.out.println("Digite o Ano do carro:");
        int ano = sc.nextInt();
        sc.nextLine();
        System.out.println("========================================================");
        TiposdeCarros.stream().filter(carrro -> carrro.getAno() == ano).forEach(System.out::println);
        System.out.println("========================================================");
       }
        
    }
    public static void ListarTudo(Scanner sc){
         sc.nextLine();
        if(carros.isEmpty()){
            System.out.println("Nenhuma informção cadastrada!!");
            return;
        }
        for (String cpf : carros.keySet()) {
            System.out.println("CPF:"+cpf);
            System.out.println("========================================================");
            for (Concessionaria c : carros.get(cpf)) {
                    System.out.println(c);
            }
        }
    }
    public static void Remover(Scanner sc){
         sc.nextLine();
        if(carros.isEmpty()){
            System.out.println("Nenhuma informção cadastrada!!");
            return;
        }
           System.out.println("Digite o CPF do cliente:");
            String cpf = sc.nextLine();
             List<Concessionaria> TiposdeCarros = carros.get(cpf);

              if(TiposdeCarros == null){
            System.out.println("Nenhum carro associado a esse CPF");
            return;
         }
               else if (TiposdeCarros != null){
                    System.out.println("Digite o ID do carro:");
                    int id = sc.nextInt();
                    TiposdeCarros.removeIf(carro -> carro.getId() == id);
                    System.out.println("Carro removido com sucesso");
               }
    }
    public static void Atualizar(Scanner sc){
        if(carros.isEmpty()){
            System.out.println("Nenhuma informação cadastrada!!");
            return;
        }
        sc.nextLine();
        System.out.println("Digite o cpf do cliente:");
        String cpf = sc.nextLine();
        List<Concessionaria> TiposdeCarros = carros.get(cpf);
        if ((TiposdeCarros == null)) {
            System.out.println("Nenhum carro associado ao cliente");
            return;
        }
        else{
            System.out.println("Digite a cor do carro:");
            String cor = sc.nextLine();
               for (Concessionaria concessionaria : TiposdeCarros) {
                        if(cor != concessionaria.getCor()){
                            concessionaria.setCor(cor);
                            System.out.println("Cor alterada com sucesso");
                        }
               }
        }
    }
}