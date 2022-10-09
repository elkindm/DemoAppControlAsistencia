package co.com.libisoft.demoappcontrolasistencia.view

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import co.com.libisoft.demoappcontrolasistencia.view.Destinations.*
import com.google.android.gms.location.FusedLocationProviderClient

@Composable
fun NavigationHost(
    empleadoViewModel: EmpleadoViewModel,
    fusedLocationClient: FusedLocationProviderClient
) {
    val navController= rememberNavController( )

    NavHost(navController = navController, startDestination =  InicioScreem.route) {

        composable(InicioScreem.route){
            LoginScreem(
                navegarEmpleado = {
                    navController.navigate(EmpleadoScreem.route)
                },
                navegarAdmin = {
                    navController.navigate(ManagerScreem.route)
                }
            )
        }

        composable(ManagerScreem.route){
          ManagerScreem(
              navegarInicio = {
                  navController.navigate(InicioScreem.route)
              },fusedLocationClient
          )
        }

        composable(EmpleadoScreem.route){
           EmpleadoScreem(
               navegarInicio = {
                   navController.navigate(InicioScreem.route)
               },
               viewModel = EmpleadoViewModel(),
               fusedLocationClient
           )
        }
    }
}