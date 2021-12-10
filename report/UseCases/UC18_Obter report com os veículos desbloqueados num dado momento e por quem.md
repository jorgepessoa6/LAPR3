# UC18 - Obter report com os veículos desbloqueados num dado momento e por quem

## Formato Breve

O administrativo inicia a obtenção do report com os veículos desbloqueados num dado momento e por quem. O sistema solicita o momento a visualizar. O administrativo introduz os dados. O sistema valida e apresenta os dados ao administrativo, pedindo confirmação. O administrativo confirma. O sistema gera o report com os veículos desbloqueados num dado momento e por quem, e informa o administrativo do sucesso da operação.

## SSD
![UC18-SSD.png](SSD_UC18.png)

## Formato Completo

### Ator principal

Administrativo

### Partes interessadas e seus interesses
* **Administrativo:** pretende obter report com os veículos desbloqueados num dado momento e por quem.

### Pré-condições
\-

### Pós-condições
\-

## Cenário de sucesso principal (ou fluxo básico)

1. O administrativo inicia a obtenção do report com os veículos desbloqueados num dado momento e por quem.
2. O sistema solicita o momento a visualizar.
3. O administrativo introduz os dados.
4. O sistema valida e apresenta os dados ao administrativo, pedindo confirmação.
5. O administrativo confirma.
6. O sistema gera o report com os veículos desbloqueados num dado momento e por quem, e informa o administrativo do sucesso da operação.

### Extensões (ou fluxos alternativos)

a. O administrativo solicita o cancelamento da obtenção do report com os veículos desbloqueados num dado momento e por quem.

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

### Requisitos especiais
\-

### Lista de Variações de Tecnologias e Dados
\-

### Frequência de Ocorrência
\-

### Questões em aberto
\-