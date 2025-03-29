# MEDICO, PACIENTE, CONSULTAS 

-> O nosso sistema receberá dados de médicos e pacientes. Um médico atende atende a um paciente por vez. O paciente pode ter várias consultas com diferentes médicos(no mesmo dia também).

1. O nosso sistema é de gestão de médicos para uma clinica. Ele permite o cadastro e gerenciamento de médicos, armazenando suas informações como:
- nome
- e-mail
- CRM 
- Especialidade
- endereço(logradouro, bairro, cep, cidade, uf, número, complemento)

2. Funcionalidades 
- Cadastro de médico
- Listagem de médicos cadastrados 
- Atualização de dados do médico
- Remoção de médicos 

- Construir um pacote chamado endereco dentro de model e criar uma classe Endereco com os atributos listados abaixo. Além disso, crieos getters, setters, construtor com todos os parametros e construtor sem nenhum parametro.
* Coloque todos os atributos privados e do tipo String. 

# Aula 02
Verbos HTTP
- GET -> É quando você pede algo de retorno
- POST -> É quando você passa informações.
- PUT 
- DELETE

- Request [REQUISIÇÃO] -> É o que você passa esperando o retorno
- Response [RESPOSTA] -> É a resposta que você recebe.

# Aula 03 
- `DTO`-> Padrão de projetos onde isolamos cada item que está sendo enviado pelo [simulador_de_requisição]. Data Transfer Object(Objeto de Transferência de Dados). Criação de uma classe record chamada DadosCadastroMedico, onde iremos receber os dados do json e converter em dados autonomos.

- Criação de uma classe `record`(classe do tipo imutavél, todos os atributos serão privados, terão getters e setters mas não poderá mudar os valores) chamada `DadosCadastroMedicos`, onde iremos receber os dados do json e converter em dados autônomos.

- `API` -> É um conjunto de ações e regras para a comunicação entre diferentes ferramentas. Define como os sistemas devem interagir. Normalmente, uma API oferece dados para serem consumidos pelo front-end.

- `POLIMORFISMO` -> É quando um método se comporta de maneira diferente dependendo da forma que é invocado. Significa muitas formas. Ex.:
-- Sobrecarga de método[OVERLOADING] - Tempo de compilação. 
-- Sobrescrita de método [OVERRIDING] - Tempo de execução.

- `ABSTRAÇÃO` -> É quando uma classe/método não pode ser instânciada(clonada). [abstract].

# ANOTATIONS - ANOTAÇÕES 
1. Anotações do Spring web
`@RequestMapping("/medicos")`
-> Define que a classe está mapeada para url[endpoint] /medicos.

`RestController` 
-> Define que a classe é uma classe controladora no Spring.

`GetMapping`
-> Define que o método será somente leitura.

`PostMapping`
-> Define que o método irá receber dados. 

`PutMapping`
-> Atualiza alguma informação

`DeleteMapping`
-> Deleta dados.

`@RequestBody`
-> É utilizada quando você irá receber dados pelo sumilador de requisição[insomnia], e informa que os daods serão enviados no corpo da requisição. 

2. Anotações do lombok 

`@Getter`
-> Cria todos os getteres para todos os atributos da classe.
`@Setter`
-> Cria todos os setters para todos os atributos da classe.
`@AllArgsConstructor`
-> Cria um método construtor com todos os atributos.
`@NoArgsConstructor`
-> Cria um método com nenhum dos atributos. 

3. Anotações do Spring JPA 
`@Entity`
-> É uma anotação que você irá utilizar para informar ao spring boot que a classe anotada serã uma tabela no banco de dados.

`@Table`
-> É uma anotação que você irá utilizar para criar no banco de dados uma tabela com o nome da classe anotada.
* Você pode alterar o padrão do nome da tabela utilizando: @Table(name = "nomedatabela").

`@GeneratedValue`
-> Define que a criação do ID será de forma automática. 

`@Enumerated`
-> Informa que aquele atributo é uma classe enum.

`@Embedded`
-> Anota que uma classe faz parte dessa tabela no banco de dados.

`@Embeddable`
-> Anota que essa classe irá fazer parte de uma tabela de uma outra classe

`@Id`
-> Informa que o id será a chave primária(PK) na tabela.

`@GenerateValue(strategy = GenerationType.IDENTITY)`
-> Infomra que aquele atributo terá geração de valor automatico.
-> Strategy - É a estrategia utilizada
-> GenerationType - É o tipo de geração utilizada
-> IDENTITY - A geração automatica será atraves do ID


`@GeneratedValue`
-> Informa que aquele atributo terá uma geração de valor de automática.

4. Banco De Dados

`Chave primária(PK)` -> É o atributo que identifica a tabela no banco de dados.

`Chave estrangeira(FK)` -> É o atributo que se relaciona com uma tabela que possui esse atributo como chave primária, no banco de dados.

5. Padrões de Projeto

- `DTO`-> Padrão de projetos onde isolamos cada item que está sendo enviado pelo [simulador_de_requisição]. Data Transfer Object(Objeto de Transferência de Dados). Criação de uma classe record chamada DadosCadastroMedico, onde iremos receber os dados do json e converter em dados autonomos.

- `DAO` -> É um padrão de projetos em que separamos a lógica do acesso ao banco de dados do restante da aplicação.

- `INTERFACE` -> É um tipo de padrão de projetos presente no Java, onde uma classe é declarada e ela possui atributos constantes e não pode ser instânciada. É conhecida como uma classe de contrato, onde você poderá utilizar os métodos e atributos dessa classe.

- `INJEÇÃO DE DEPENDENCIAS` ->  É um tipo de padrão de projetos[DI] onde você informa ao Spring Boot que ele irá ficar responsavel pela criação de determinado dado(ele que conhece como funciona). 

# RELACONAMENTO ENTRE TABLAS NO SPRING BOOT

`@OneToOne` -> Um para um. (Uma consulta está ligada a um único paciente).
`OneToMany` -> Um para muitos. (Um médico tem várias consultas durante o dia).
`ManyToOne` -> Muitos para um. (Várias consultas para um único médico).
`ManyToMany` -> Muitos para muitos. (Muitos pacientes para muitas consultas).

`@JoinColumn(name='fk')` -> Define o nome da coluna `alias` no banco que faz a ligação.

OBS.: 
1. Sempre defina o lado "dono" da relação`(@JoinColumn)` no lado de quem tem a `FK(chave estrangeira)`.

2.  Use o `Cascade` se quiser que a operação como `persist` ou `remove` sejam propagadas.