🔁 API - Sistema de Agendamento
Esta é uma API RESTful desenvolvida com Java e Spring Boot para gerenciar agendamentos de serviços para clínicas,barbearia entre outras. O projeto foi estruturado para resolver problemas reais de organização de horários, permitindo uma gestão eficiente entre profissionais e clientes.

🚀 Tecnologias e Ferramentas
Linguagem: Java 17+

Framework: Spring Boot 3

Banco de Dados: MySQL 

ORM: Spring Data JPA (Hibernate)

Gestão de Dependências: Maven


🏗️ Estrutura do Projeto
O projeto segue as melhores práticas de desenvolvimento, utilizando uma arquitetura em camadas para facilitar a manutenção e escalabilidade:

Controller: Camada de entrada que gerencia as requisições HTTP e as rotas da API.

Service: Onde residem as regras de negócio (ex: validação de horários conflitantes).

Repository: Interface que abstrai o acesso ao banco de dados via JPA.

Model/Entity: Representação das tabelas do banco de dados (Agendamento, Cliente, Profissional).

🛠️ Funcionalidades Principais
Cadastro de Clientes e Profissionais: Gestão completa dos perfis.

Agendamento de Horários: Registro de data, hora e serviço solicitado.

Consulta de Disponibilidade: Listagem de horários disponíveis por profissional.

Persistência de Dados: Garantia de que as informações estão seguras e organizadas no banco de dados.

Desenvolvido por Rafael SaCa
