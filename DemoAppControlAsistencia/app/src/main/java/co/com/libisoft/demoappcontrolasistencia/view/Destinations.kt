package co.com.libisoft.demoappcontrolasistencia.view

sealed class Destinations(
    val route:String
){
    object InicioScreem:Destinations(route = "inicio")
    object EmpleadoScreem:Destinations(route = "empleado")
    object ManagerScreem:Destinations(route = "admin")
}
