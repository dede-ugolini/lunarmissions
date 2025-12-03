# Lunar Missions

Bem vindo a Lunar Systems, agência espacial proprietária de um sistema feito em Java que controla operações espaciais com destino à Lua e quem sabe outros planetas do vasto Universo.

## Depêndencias

Existem alguns glifos (glyphs) que para serem exibidos em um terminal dependem de nerdfonts
por exemplo o famoso foguetinho 🚀. [Nerd Fonts](https://www.nerdfonts.com/)

## Executar o Projeto

### Linux

Primeiro, altere as permissões do arquivo `build.sh` para poder executar o script.

```sh
chmod +x build.sh
```

Execute o arquivo de build:

``sh
./build.sh

### Caso não funcione por script

```sh
mvn package
```

Na raiz do projeto execute:

```sh
java -jar target/lunarmissions-1.0-SNAPSHOT.jar
```
