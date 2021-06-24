# BankApp
Aplicativo "bancário" fictício com uma arquitetura de software limpa, utilizando o que há de mais recente nos componentes da arquitetura Android, Kotlin Coroutines e outras bibliotecas modernas.

O usuário pode fazer o login com e-mail ou CPF e senha com pelo menos uma letra maiuscula, um caracter especial e um caracter alfanumérico (após os campos serem validados, o aplicativo criará e salvará o acesso em "Shared Preferences"). A segunda tela apresenta uma lista dos lançamentos de sua conta bancária (após a realização do acesso).

Componentes de arquitetura usados pelo aplicativo:

- Navigation Component
- ViewModel
- Repositório
- LiveData
- Shared Preferences
- Retrofit
- Hilt (injeção de dependências)
- Lifecycle
- Mockito para testagem do display e chamada a API

O aplicativo segue a arquitetura "limpa" e foi dividido em camadas por recurso.

O fluxo geral do aplicativo é:

View se comunica com um ViewModel, então ViewModel executa um UseCase que acessa um repositório (fazendo então a chamada da API). O resultado é trazido de volta à visualização por meio do fluxo de LiveData ou pela retomada de uma coroutine que foi iniciada pela visualização dentro de um escopo de ciclo de vida.

O aplicativo está usando o Hilt como uma estrutura de injeção de dependência. Cada recurso declara seu próprio módulo que é usado para a construção de todo o gráfico de dependência.

NOTAS:

- Quando o usuário fizer login, não importa o usuário/senha inseridos, o acesso base já registrado na API será utilizado para fazer a chamada. 
- Para os testes, o framework "Mockito" foi selecionado pela sua estrutura eficaz e capacidade de cria esboço dos objetos necessários ao invés de instanciá-los de fato, dando controle total sobre esse objeto e suas interações.
