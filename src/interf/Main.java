package interf;
	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;
	import javax.imageio.*;
public class Main extends JFrame  {
	public static Agenda minhaAgenda = new Agenda();
	
	private JMenuItem menuAbreAgenda = new JMenuItem("Abrir Agenda");
	private JMenuItem menuFechaAgenda = new JMenuItem("Fechar Agenda");
	private JRadioButtonMenuItem[] menuItemEstilo = new JRadioButtonMenuItem[3];

	private JMenu menuAgenda = new JMenu("Agenda");
	private JMenu menuEstilo = new JMenu("Estilo");

	private JMenuBar menuBar = new JMenuBar();

	private InterfaceAgenda agenda = null;

	private JDesktopPane desktop; //cria-se a janela principal
	private ButtonGroup group = new ButtonGroup();

	public static void main(String[] args){
	
	Main m = new Main(); 
	}
	public Main(){ //método constructor, que monta a janela principal do programa
		super("TRABALHO SOBRE INTERFACE GRÁFICA");

		desktop = new JDesktopPane(){

		public void paintComponent(Graphics g){
		
		try{
		
		super.paintComponents(g);

		Image img = ImageIO.read(new java.net.URL(
		this.getClass().getResource("imagens/DESKTOP.gif"), "DESKTOP.gif"));
		
		if (img != null){
		g.drawImage(img, 0, 0, 800, 600, this);
		}

		}catch(Exception e){
			e.printStackTrace();
		}
	}
};
			desktop.setBackground(Color.WHITE);

			
			Icon imgSair = new ImageIcon("C:/Users/Aluno_2/workspace/Agenda/bin/imagens/AGENDA2.png");
			JButton btnSair = new JButton(imgSair);
			
			menuAgenda.setIcon(new ImageIcon("C:/Users/Aluno_2/workspace/Agenda/bin/imagens/AGENDA2.png"));

			/*Icon imgSair = new ImageIcon("C:/Users/Aluno_2/workspace/Agenda/bin/imagens/AGENDA2.png");
			JButton btnSair = new JButton(imgSair)*/
			
			/*menuAbreAgenda.setIcon(new ImageIcon("C:/Users/Aluno_2/workspace/Agenda/bin/imagens/AGENDA2.png"));

			menuEstilo.setIcon(new
			ImageIcon(this.getClass().getResource("imagens/ESTILO.png")));*/
			
			
			menuAbreAgenda.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			menuAgendaActionPerformed(e);
			}
		});

			/*menuFechaAgenda.setIcon(new
			ImageIcon(this.getClass().getResource("imagens/FECHAR.png")));
	*/
			menuFechaAgenda.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				menuFechaAgendaActionPerformed(e);
			}
		});
			
			menuItemEstilo[0] = new JRadioButtonMenuItem("Metal");
			menuItemEstilo[0].setSelected(true);
			//menuItemEstilo[0].setIcon(new
			
			/*ImageIcon(this.getClass().getResource("imagens/JAVA.png")));
			menuItemEstilo[1] = new JRadioButtonMenuItem("Motif");
			menuItemEstilo[1].setIcon(new*/
			
	/*		ImageIcon(this.getClass().getResource("imagens/LINUX.png")));
			menuItemEstilo[2] = new JRadioButtonMenuItem("Windows");
			menuItemEstilo[2].setIcon(new
			ImageIcon(this.getClass().getResource("imagens/WINDOWS.png")));*/
			
			
			for (int i = 0; i < menuItemEstilo.length; i++){
			group.add(menuItemEstilo[i]);
			/*menuEstilo.add(menuItemEstilo[i]);*/
			
			menuItemEstilo[i].addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
			menuEstiloItemStateChanged(e);
		}
	});
}
			menuAgenda.add(menuAbreAgenda);
			menuAgenda.addSeparator();
			menuAgenda.add(menuFechaAgenda);

			menuBar.add(menuAgenda);
			menuBar.add(menuEstilo);

			this.getContentPane().add(desktop);

			this.setJMenuBar(menuBar);
			this.setExtendedState(JFrame.MAXIMIZED_BOTH);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setVisible(true);
			}
		private void menuAgendaActionPerformed(ActionEvent e){

		agenda = InterfaceAgenda.getInstance();
		desktop.remove(agenda);
		desktop.add(agenda);
		agenda.setVisible(true);

		}
		private void menuFechaAgendaActionPerformed(ActionEvent e){

			
			if (InterfaceAgenda.isInstance()){
			int ret = JOptionPane.showConfirmDialog(this,
			"Deseja Fechar?",
			"Fechar",
			JOptionPane.OK_CANCEL_OPTION,
			JOptionPane.QUESTION_MESSAGE);

			if (ret == JOptionPane.OK_OPTION){
			agenda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			agenda.destroyInstance();
			}
		}
	}
		private void menuEstiloItemStateChanged(ItemEvent e){

			for (int i = 0; i < menuItemEstilo.length; i++){

			if (menuItemEstilo[i].isSelected()){
			atualizar(i);
			}
		}
	}

			public void atualizar(int valor){
			UIManager.LookAndFeelInfo[] look = UIManager.getInstalledLookAndFeels();

			try{
			
			UIManager.setLookAndFeel(look[valor].getClassName());
			SwingUtilities.updateComponentTreeUI(this);
			
		}
		
			catch(Exception e){
			e.printStackTrace();
		}
			}
}

