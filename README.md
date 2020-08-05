# EventoApp
Projeto com SpringBoot e framework css materialize. 

Cadastro de Eventos

- O sistema é baseado no sistema desenvolvido por Michelli Brito em seu canal do Youtube. Entretanto, fiz algumas modificações que não foram apresentadas nas vídeo aulas. Algumas destas modificações são:

- Uso da camada service para comunicação com banco de dados.
- Método de atualização para um evento e para um convidado.
- Camadas de Segurança como: autenticação a partir de um banco de dados, diferentes tipos de usuário,
implementação de interface UserDatailsService, criação das entidades usuario e role e relacionamento de tabelas entre as duas entidades citadas.

#Instruções
- Projeto com back-end e front-end funcionais. 
- Clonar projeto para sua máquina.
- O projeto tem autenticação com dois tipos de usuários(admin, user).
- A página de login é a gerada pelo próprio spring security.
- As autenticações cadastradas no banco são:
login: admin senha: 123 e login: user senha: 123
- Somente o usuário autenticado como administrador tem permissão para cadastrar um convidado em um evento específico.
- O sistema ainda está em desenvolvimento e sempre que puder irei trazer atualizações.
