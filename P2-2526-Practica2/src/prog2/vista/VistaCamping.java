package prog2.vista;

import prog2.model.Camping;

public class VistaCamping {
    private Camping camping;
    static private enum OpcionsMenuPrincipal {MENU_PRINCIPAL_OPCIO1,MENU_PRINCIPAL_OPCIO2,MENU_PRINCIPAL_SUBMENU1,MENU_PRINCIPAL_SORTIR};

    public VistaCamping(Camping camping) {
        this.camping = camping;
        inicialitzaDadesCamping();
    }

    public void gestioCamping() {
        Menu<ExempleMenu.OpcionsMenuPrincipal> menu = new Menu<ExempleMenu.OpcionsMenuPrincipal>("Menú", ExempleMenu.OpcionsMenuPrincipal.values());
    }
}
