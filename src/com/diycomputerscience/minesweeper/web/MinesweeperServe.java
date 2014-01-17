package com.diycomputerscience.minesweeper.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.diycomputerscience.minesweeper.Board;
import com.diycomputerscience.minesweeper.Point;
import com.diycomputerscience.minesweeper.RandomMineInitializationStrategy;
import com.diycomputerscience.minesweeper.UncoveredMineException;

/**
 * Servlet implementation class MinwsweeperServe
 */
public class MinesweeperServe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MinesweeperServe() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
						 HttpServletResponse response) 
								 throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, 
						  HttpServletResponse response) 
								  throws ServletException, IOException {
		System.out.println("Control in doPost()");
		String action = request.getParameter("action");
		//TODO: Use action to figure out what to do
		
		// Display the board
		displayBoard(request, response);		
	}
	
	private void displayBoard(HttpServletRequest request,
							  HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher("game.jsp").forward(request, response);
	}

}
