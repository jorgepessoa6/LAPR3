﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿# RELATÓRIO LAPR3 2DD GRUPO 4 #

Realizado por: Ricardo Lopes: 1180669; Gabriel Vieira: 1180683; Jorge Pessoa: 1180761; Diogo Soares: 1180704; Francisco Ferreira: 1180682; Luis Blanco: 1170822
---------------------------------

# DIAGRAMA DE CASOS DE USO #

![./report/UCD.png](./report/UCD.png)

# MODELO DOMÍNIO #

![./report/MD.png](./report/MD.png)

# MODELO RELACIONAL #

![./report/RelationModel.png](./report/ModeloRelacional.png)

# Funcionalidades #
Apresentam-se de seguida as funcionalidades implementadas, bem como a descrição de cada uma delas acompanhadas dos diagramas de sequência.

# Remover um parque #
Esta funcionalidade permite ao administrador remover um parque do sistema.
![./report/DesignOO/SD_UC2.png](./report/DesignOO/SD_UC2.png)

# Consultar lugares de estacionamento disponíveis #
Esta funcionalidade permite ao utilizador consultar os lugares de estacionamento disponíveis para um determinado parque.
![./report/DesignOO/SD_UC4.png](./report/DesignOO/SD_UC4.png)

# Remover um veículo #
Esta funcionalidade permite ao administrador remover um veículo do sistema que consiste em alterar o estado dele, de disponível para não disponível. Desta forma, o veículo não é removido literalmente do sistema.

![./report/DesignOO/SD_UC13.png](./report/DesignOO/SD_UC13.png)

# Adicionar pontos de interesse #
Esta funcionalidade permite adicionar pontos de interesse ao sistema.
![./report/DesignOO/SD_UC15.png](./report/DesignOO/SD_UC15.png)

# Gerar fatura mensal #
Esta funcionalidade permite gerar a fatura mensal.
![./report/DesignOO/SD_UC16.png](./report/DesignOO/SD_UC16.png)

# Obter report com os veículos desbloqueados num dado momento e por quem #
Esta funcionalidade permite obter um report com os veículos desbloqueados num dado momento e por quem.
![./report/DesignOO/SD_UC18.png](./report/DesignOO/SD_UC18.png)

# Obter os parques mais próximos da posição atual do utilizador, fornecendo a sua localização exata #
Esta funcionalidade permite obter parques mais próximos da posição atual do utilizador, fornecendo a sua localização exata.
![./report/DesignOO/SD_UC5.jpg](./report/DesignOO/SD_UC5.jpg)

# Alugar um veículo #
Esta funcionalidade permite alugar um veículo, sendo que apenas um veículo pode estar em uso por utilizador.
![./report/DesignOO/SD_UC10.jpg](./report/DesignOO/SD_UC10.jpg)

# Calcular o vento #
Esta funcionalidade permite calcular o vento de um determinado caminho.
![./report/DesignOO/SD_UC26_CalcularVento.jpg](./report/DesignOO/SD_UC26_CalcularVento.jpg)

# Fazer um Pedido #
Esta funcionalidade permite fazer um pedido passando por parametro o email, se é scooter ou não, tipo de veiculo, id do parque e a distancia a percorrer.
![SD_UC7.png](./report/DesignOO/SD_UC7.png)

# Estacionar um veículo #
Esta funcionalidade permite estacionar um veículo acabando assim uma trip fornecendo o codigo, latitude e longitude.
![SD_UC8.png](./report/DesignOO/SD_UC8.png)

# Receber email com o estado do veiculo #
Esta funcionalidade permite receber um email ao estacionar um veículo, fornecendo o codigo pedido e se foi bem estacionado ou náo
![SD_UC25.png](./report/DesignOO/SD_UC25.png)

# Escolher rota mais curta que passe em pontos de interesse dados pelo utilizador #
Esta funcionalidade calcula o caminho mais curto entre 2 parques passando em pontos fornecidos pelo utilizador
![SD_UC24.png](./report/DesignOO/SD_UC24.png)

# Escolher rota mais eficientemente energética entre dois parques #
Esta funcionalidade calcula o caminho mais eficientemente energético entre dois parques, retornando a distancia.
![SD_UC28.jpg](./report/DesignOO/SD_UC28.jpg)

# Escolher rota mais eficientemente energética entre dois parques que passe em pontos de interesse dados pelo utilizador #
Esta funcionalidade calcula o caminho mais eficientemente energético entre dois parque que passe em pontos de interesse dados pelo utilizador.
![SD_UC29.jpg](./report/DesignOO/SD_UC29.jpg)

# Registar na aplicação
Esta funcionalidade permite que um utilizador não registado se registe na aplicação, utilizando o seu nome, email, género, peso, carta de condução e CCV, de modo a puder usufruir de todos os benefícios de ser utilizador registado.
![SD_UC3.png](./report/DesignOO/SD_UC3.png)

# Atualizar um parque
Esta funcionalidade permite que o administrador atualize a informação de um parque, para que os utilizadores consultem informações atualizadas e fidedignas desse parque.
![SD_UC1.png](./report/DesignOO/SD_UC1.png)

# Atribuir pontos
Esta funcionalidade disponibiliza a atribuição de pontos do utilizador. Assim que um veículo seja estacionado, o sistema gera a atribuição de pontos, de modo a que os utilizadores possam usufruir dos seus pontos. 
[SD_UC17.png](./report/DesignOO/SD_UC17.png)    

# Obter relatório com a carga atual dos veículos e a estimativa de tempo até à carga total de cada de um dos veículos para um parque
Esta funcionalidade dá a possibilidade ao administrador de adquirir um relatório de um parque com as cargas atuais e respetivos tempos de carga total de cada veículo, de modo a adquirir infomações sobre os veículos (escooters) do parque. 
![SD_UC20.png](./report/DesignOO/SD_UC20.png)

# Gerar fatura de uso de veículo
Esta funcionalidade disponibiliza o facto que assim que o pedido esteja finalizado seja gerada a fatura do pedido, de modo que os utilizadores possam visualizar a descrição dos valores debitados de acordo com o pedido.
![SD_UC22.png](./report/DesignOO/SD_UC22.png)

# Mostrar veículos dísponiveis num parque #
Esta funcionalidade permite ao utilizador saber os veículos dísponiveis num parque.
![./report/Design OO/SD_UC6.png](./report/Design OO/SD_UC6.png)

# Consultar quantidade de calorias queimadas #
Esta funcionalidade permite ao cliente simular a quantidade de calorias que iria gastar numa viagem entre parques.
![./report/DesignOO/SD_UC9.jpg](./report/DesignOO/SD_UC9.jpg)

# Adicionar um Paque #
Esta funcionalidade permite ao administrador adicionar um parque do sistema.
![./report/DesignOO/SD_UC11.jpg](./report/DesignOO/SD_UC11.jpg)

# Atualizar um veículo #
Esta funcionalidade permite ao administrador atualizar um veículo do sistema, sendo que os dados que podem ser atualizados são o seu estado (disponivel ou indisponivel) e o parque que se encontra associado de momento.
![./report/DesignOO/SD_UC14.jpg](./report/DesignOO/SD_UC14.jpg)

# Carregar Scooter #
Esta funcionalidade permite ao administrador carregar uma Scooter durante um intervalo de tempo.
![./report/DesignOO/SD_UC19.jpg](./report/DesignOO/SD_UC19.jpg)

# Obter Report com os veículos que não têm carga para fazer uma viagem #
Esta funcionalidade permite ao administrador obter um Report com os veículos que não têm carga para fazer uma viagem .
![./report/DesignOO/SD_UC27.jpg](./report/DesignOO/SD_UC27.jpg)

# Adicionar um veículo #
Esta funcionalidade permite ao administrador adicionar um veículo.
![./report/Design OO/SD_UC12.png](./report/Design OO/SD_UC12.png)

# Caminho mais curto entre 2 parques #
Esta funcionalidade permite ao utilizador saber o caminho mais curto entre dois parques.
![./report/Design OO/SD_UC23.png](./report/Design OO/SD_UC23.png)

# Realizar pedido antecipado #
Esta funcionalidade permite ao utilizador saber o seu historico de veiculos utilizados.
![./report/Design OO/SD_UC21.png](./report/Design OO/SD_UC21.png)
