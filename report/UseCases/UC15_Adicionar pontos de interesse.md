# UC15 - Adicionar pontos de interesse

## Formato Breve

O administrativo inicia a adição de ponto de interesse. O sistema solicita os dados a preencher relativos ao ponto de interesse. O administrativo introduz os dados. O sistema valida e apresenta os dados ao administrativo, pedindo confirmação. O administrativo confirma. O sistema adiciona o ponto de interesse e informa o administrativo do sucesso da operação.

## SSD
![UC15-SSD.png](SSD_UC15.png)

## Formato Completo

### Ator principal

Administrativo

### Partes interessadas e seus interesses
* **Administrativo:** pretende adicionar pontos de interesse ao sistema.
* **Utilizador:** pretende observar esses pontos de interesse na aplicação.
* **Empresa:** pretende que a informação relativa aos pontos de interesse esteja atualizada.

### Pré-condições
\-

### Pós-condições
A informação do ponto de interesse é adicionada ao sistema.

## Cenário de sucesso principal (ou fluxo básico)

1. O administrativo inicia a adição de pontos de interesse.
2. O sistema solicita os dados a preencher relativos ao ponto de interesse.
3. O administrativo introduz os dados.
4. O sistema valida e apresenta os dados ao administrativo, pedindo confirmação.
5. O administrativo confirma.
6. O sistema adiciona o ponto de interesse e informa o administrativo do sucesso da operação.

### Extensões (ou fluxos alternativos)

a. O administrativo solicita o cancelamento da adição do ponto de interesse.

> O caso de uso termina.

4a. Dados mínimos obrigatórios em falta.
>	1. O sistema informa quais os dados em falta.
>	2. O sistema permite a introdução dos dados em falta (passo 3)
>
	>	2a. O administrativo não altera os dados. O caso de uso termina.

4b. O sistema detecta que os dados introduzidos (ou algum subconjunto dos dados) são inválidos.
> 1. O sistema alerta o administrativo para o facto. 
> 2. O sistema permite a sua alteração (passo 3).
> 
	> 2a. O administrativo não altera os dados. O caso de uso termina. 

4c. O sistema detecta que os dados introduzidos (ou algum subconjunto dos dados) são repetidos, e portanto já existem no sistema.
> 1. O sistema alerta o administrativo para o facto. 
> 2. O sistema permite a sua alteração (passo 3).
> 
	> 2a. O administrativo não altera os dados. O caso de uso termina. 

### Requisitos especiais
\-

### Lista de Variações de Tecnologias e Dados
\-

### Frequência de Ocorrência
\-

### Questões em aberto
\-