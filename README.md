La prueba se realizo con la version de 17 de java y la version 3 de spring boot.
Se uno restTamplate para la comunicacion la el api de TMDB, para ciertos metodos get.
La aplicacion tiene su documentcion con swagger.
Se hizo el despliegue en AWS.
El de aplicacion desplejada es: http://pruebatalataa-env.eba-vgujp7mx.us-east-2.elasticbeanstalk.com/swagger-ui/index.html#/

¿QUE SE PUEDE HACER EN LA APLICACION?
1.permite consultar u obtener las peliculas de la api TMDB 
2.t buscar pelicula a traves del id en el api de TMBD.
3.Registrar una pelicula como favorita solo si esta se encuentra en la bd del TMDB.
4.Eliminar una pelicula que premiavemte se registro como favorita.
5.Actualizar una pelicula que premiavemte se registro como favorita.
6.Obtener la lista de las peliculas rregistradas como favorita

NOTA IMPORTANTE: Actualmente solo se puede haceren el api de TMDB llamadas get, para los demas pide la aprovacion de un access Token y se aprueba el token 
pero realmente no lo hace.Este es un prolema actualmente de la api  y muchos foros donde se confirma esto. Por esta razon el esta aplicacion los metodos put, post,
delete se esta utlizando la base de datos h2.




