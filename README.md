StartEJB - Sistema de Cadastro de Pessoas
Este é um projeto boilerplate de uma aplicação corporativa utilizando a stack Java EE 8, desenvolvida para rodar no servidor de aplicação WildFly. A aplicação demonstra um CRUD completo de um relacionamento um-para-muitos (Pessoa e Telefones) com persistência em banco de dados e interface rica.
🚀 Tecnologias Utilizadas
Java 8: Linguagem base do projeto.
Java EE 8 (Jakarta EE):
EJB 3.2: Camada de negócio e gerenciamento transacional automático.
CDI 2.0: Injeção de dependências e gerenciamento de Beans.
JPA 2.2 / Hibernate: Mapeamento objeto-relacional e persistência.
JSF 2.3: Framework MVC para a camada de visualização.
Bean Validation: Validação de dados nas entidades.
PrimeFaces 12+: Suíte de componentes UI para uma interface moderna e responsiva.
Maven: Gerenciamento de dependências e automação do build.
WildFly: Servidor de aplicação (Runtime).
📦 Estrutura do Projeto
com.demo.startejb.model: Entidades JPA (Pessoa, Telefone).
com.demo.startejb.repository: Camada de persistência usando EJBs @Stateless.
com.demo.startejb.controller: Managed Beans JSF para integração com a UI.
src/main/webapp: Páginas .xhtml e configurações web.
src/main/resources/META-INF: Configuração do persistence.xml.
🛠️ Configuração e Instalação
1. Pré-requisitos
WildFly (versão 10 ou superior recomendada).
Banco de Dados (PostgreSQL/MySQL).
Maven instalado.
2. Configuração do Servidor (WildFly)
Antes de rodar a aplicação, você deve configurar o DataSource no WildFly:
Adicione o driver JDBC como um módulo no diretório modules.
No standalone.xml, registre o driver e o datasource com o nome JNDI:
java:jboss/datasources/MeuAppDS
3. Build e Deploy
Para gerar o arquivo .war sem a versão no nome (conforme configurado no pom.xml):
bash
mvn clean package
Use o código com cuidado.
O arquivo startejb.war será gerado na pasta target. Basta copiá-lo para:
WILDFLY_HOME/standalone/deployments/
📝 Funcionalidades
Cadastro de Pessoa com múltiplos telefones na mesma tela.
Remoção em cascata (ao deletar uma pessoa, os telefones são removidos).
Validação de campos obrigatórios via Bean Validation.
Interface reativa com AJAX usando PrimeFaces.
