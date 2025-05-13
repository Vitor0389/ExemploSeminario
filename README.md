Exemplo do seminário sobre GitHub Actions


## 🚀 Como Executar com Docker

### ✅ Pré-requisitos

- [Docker instalado]
- `Dockerfile` e `pom.xml` na raiz do projeto (Já está na raiz por padrão, mas verifique por favor)

### 📦 Passos

1. **Clone o repositório**:
   bash (terminal de comando):
   git clone https://github.com/seu-usuario/testes.git
   cd testes

2. **Construa a imagem Docker**:
     bash(terminal de comando):
     docker build -t testes-app

3. **Execute o Container**

    bash(terminal de comando):
    docker run --rm testes-app
   
Se quiser compilar executando os testes, remova -DskipTests do comando Maven no Dockerfile.
