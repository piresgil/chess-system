/**
* Pacote tabuleiro de jogo
*/
package boardgame;

/**
 * Class Board Tabuleiro
 */
public class Board {
	/**
	 * Variaveis row, column piece que sera uma matriz [][] - muitas pe�as no
	 * tabuleiro
	 */
	private int rows;
	private int columns;
	private Piece[][] pieces;

	/**
	 * Construtor
	 * 
	 * Recebe row e column
	 * 
	 * Instancia matriz de pieces
	 * 
	 * Trata excep��es
	 */
	public Board(int rows, int columns) {
		/**
		 * Tratamento de excep��es
		 * 
		 * BoardException
		 * 
		 * Testa de row, column maiores que 1
		 */
		if (rows < 1 || columns < 1) {
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
		}
		this.rows = rows;
		this.columns = columns;
		/**
		 * Instancia a matriz, com row e column
		 */
		pieces = new Piece[rows][columns];
	}

	/**
	 * Getters Setter
	 * 
	 * Apenas getters para que n�o existam inconscistencias
	 */
	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	/**
	 * Metodos Especiais
	 * 
	 * Metodo que retorna uma pe�a informando row column
	 * 
	 * Trata excep��es
	 */
	public Piece piece(int rows, int columns) {
		/**
		 * Tratamento de excep��es BoardException Testa se existe posi��es disponiveis
		 * uzando metodo position exists
		 */
		if (!positionExists(rows, columns)) {
			throw new BoardException("Position not on the Board");
		}
		return pieces[rows][columns];
	}

	/**
	 * Metodos Especiais Sobrecarga
	 * 
	 * Do metodo Piece Retornando uma poci��o numa determinada row e column
	 * 
	 * Trata excep��es
	 */
	public Piece piece(Position position) {
		/**
		 * Tratamento de excep��es
		 * 
		 * BoardException
		 * 
		 * Testa se existe posi��es disponiveis uzando metodo position exists
		 */
		if (!positionExists(position)) {
			throw new BoardException("Position not on the Board");
		}
		return pieces[position.getRow()][position.getColumn()];
	}

	/**
	 * Metodo place Piece
	 * 
	 * Recebe uma Piece e uma Position
	 * 
	 * Trata excep��es
	 */
	public void placePiece(Piece piece, Position position) {
		/**
		 * Tratamento de excep��es
		 * 
		 * BoardException
		 * 
		 * Testa se existe pe�a na posi��o uzando metodo there is a piece
		 */
		if (thereIsAPiece(position)) {
			throw new BoardException("There is alredy a piece on position " + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}

	/**
	 * Metodo Remove piece
	 * 
	 * Recebe uma Position e
	 * 
	 * cria variavel auxiliar do tipo Piece para receber valor da Position
	 * 
	 * Reseta como nula a variavel auxiliar
	 * 
	 * Reseta pe�as nas poci��es row e column como nulas
	 * 
	 * Retorna variavel auxiliar
	 * 
	 * Trata excep��es
	 */
	public Piece removePiece(Position position) {
		/**
		 * Tratamento de excep��es
		 * 
		 * BoardException
		 * 
		 * Testa se existe posi��es disponiveis uzando metodo position exists
		 */
		if (!positionExists(position)) {
			throw new BoardException("Position not on the Board");
		}
		if (piece(position) == null) {
			return null;
		}
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getRow()][position.getColumn()] = null;
		return aux;
	}

	/**
	 * Metodos de verifica��o - position exists
	 * 
	 * Metodos que verifica a existencia de posi��o Recebe row e column
	 * 
	 * Retorna True quando row/column estiver entre zero e rows/columns (variaveis
	 * privadas da class Board (tamanho da matriz))
	 */
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}

	/**
	 * Metodos de verifica��o - position exists Sobrecarga que verifica Posi��o
	 * Recebe uma Position uza o metodo da sob-carga para testar a Posi��o Retorna
	 * True quando a Posi��o na row, column forem True conforme metodo da sob-carga
	 */
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}

	/**
	 * Metodos de verifica��o - there is a piece
	 * 
	 * Metodo que verifica se existe pe�a na posi��o
	 * 
	 * Recebe uma Position
	 * 
	 * Retorna a pe�a na posi��o que seja diferente de nulo
	 * 
	 * Trata excep�oes
	 */
	public boolean thereIsAPiece(Position position) {
		/**
		 * Tratamento de excep��es
		 * 
		 * BoardException
		 * 
		 * Testa se existe posi��es disponiveis uzando metodo position exists
		 */
		if (!positionExists(position)) {
			throw new BoardException("Position not on the Board");
		}
		return piece(position) != null;
	}
}