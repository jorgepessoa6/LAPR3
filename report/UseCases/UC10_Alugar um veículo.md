# UC10 - Alugar um ve�culo

## Formato Breve

O utilizador solicita o aluguer de um ve�culo. O sistema solicita os dados necessarios(i.e. username, idVehicle, idPark). O utilizador introduz os dados necessarios. O sistema apresenta os dados inseridos, pedindo confirma��o. O utilizador confirma. O sistema informa o utilizador do sucesso da opera��o. (Apenas um ve�culo pode estar desbloqueado por um utilizador)

## SSD
![UC10_SSD.jpg](SSD_UC10.jpg)

## Formato Completo

### Ator principal

Administrativo

### Partes interessadas e seus interesses
* **Utilizador:** pretende alugar um ve�culo.
* **Empresa:** pretende que os utilizadores aluguem veiculos.

### Pr�-condi��es
O ve�culo tem de estar registado no sistema e n�o pode estar em uso.

### P�s-condi��es
O ve�culo fica em uso.

## Cen�rio de sucesso principal (ou fluxo b�sico)

1. O utilizador solicita o aluguer de um ve�culo.
2. O sistema solicita os dados necessarios(i.e. username, idVehicle, idPark).
3. O utilizador introduz os dados necessarios.
4. O sistema apresenta os dados inseridos, pedindo confirma��o.
5. O utilizador confirma. 
6. O sistema informa o utilizador do sucesso da opera��o.

### Extens�es (ou fluxos alternativos)

a. O utilizador solicita o cancelamento do aluguer de um ve�culo.

> O caso de uso termina.

4a. Dados m�nimos obrigat�rios em falta.
>	1. O sistema informa quais os dados em falta.
>	2. O sistema permite a introdu��o dos dados em falta (passo 3)
>
	>	2a. O utilizador n�o altera os dados. O caso de uso termina.

4b. O sistema detecta que os dados introduzidos (ou algum subconjunto dos dados) s�o inv�lidos.
> 1. O sistema alerta o utilizador para o facto. 
> 2. O sistema permite a sua altera��o (passo 3).
> 
	> 2a. O utilizador n�o altera os dados. O caso de uso termina. 

### Requisitos especiais
\-

### Lista de Varia��es de Tecnologias e Dados
\-

### Frequ�ncia de Ocorr�ncia
\-

### Quest�es em aberto
\-