# desafiocljapi

Projeto para criação de app REST API (clone do Twitter) na plataforma Clojure

## Equipe

* <a href="mailto:elmon.noronha@gmail.com">Elmon Noronha<a>

## Apresentação da solução

Conforme solicitado, o desafio deste projeto consistia em desenvolver, a partir de linguagem de programação --- neste caso, Clojure --- uma REST API estilo Twitter que permitisse as seguintes operações:

* Criar um novo tweet
* Listar seus próprios tweets
* Visualizar seu próprio tweet

Além das acima, um rol de outras funcionalidades (**bônus**) foram sugeridas. Neste projeto, as seguintes foram implementadas:

* Autenticação (simples, com usuário e senha (aberta) em banco de dados)
* Curtir (e contar curtidas)
* Seguir (e contar seguidores e seguindo)

## Plataforma selecionada

Foi preferido pela equipe a linguagem de programação **_Clojure_** dentre a lista sugerida, devido à possibilidade de se transferir experiência em contato anterior com a linguagem **Common Lisp**, da mesma família.

Também foram selecionadas as seguintes ferramentas de dsenvolvimento:

* [_Eclipse_](https://www.eclipse.org) (IDE)
* [_Leiningen_](https://leinigen.org) (_build automation tool_ mais popular no mundo Clojure) 

Para facilitar o desenvolvimento deste projeto, recorreu-se a frameworks da comunidade Clojure específicos para as funcionalidades a serem implementadas, a saber:

* [_Ring_](https://github.com/ring-clojure): framework para tratamento de chamadas HTTP de baixo nível e servidor web (Eclipse Jetty)
* [_Compojure_](https://github.com/weavejester/compojure): ferramenta para manipulação de rotas, trabalhando integrada ao _Ring_
* [_Clojure JDBC_](https://github.com/clojure/java.jdbc): pacote para utilização de camada JDBC de acesso a banco de dados
* [_SQlite_](https://www.sqlite.org/): banco de dados embutido para utilização em fase de desenvolvimento, no caso deste projeto

Mais detalhes em [**project.clj**](./project.clj)

## Execução do app

Fazer download de **target/uberjar/desafiocljapi-0.1.0-SNAPSHOT-standalone.jar** e executá-lo como segue abaixo:

    $ java -jar desafiocljapi-0.1.0-SNAPSHOT-standalone.jar
    
A porta disponível será **3000** ou incrementos disto

## Exemplo de teste

É possível fazer testes com as seguintes chamadas da API, além da autenticação:

* _POST /statuses/update_ (parâmetro "text")
* _GET /statuses/lookup_ (sem parâmetros)
* _GET /statuses/show/:id_ (parâmetro id, o id do tweet)

Sugerimos a utilização do utilitário **_curl_**

## Melhorias futuras


## Bugs


## Licença

Copyright © 2019 Elmon Noronha

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
