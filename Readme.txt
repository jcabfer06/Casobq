He descargado el SDK de Android de http://developer.android.com/sdk/index.html

Descargo el JDK también, de http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

Creo una cuenta en sandbox.evernote.com

Obtengo la API Key de Evernote (con acceso completo, para poder leer y editar notas)

Descargo la API de https://github.com/evernote/evernote-sdk-android

He iniciado el proyecto vacío.

Añado los campos de texto para introducir el usuario y la contraseña. También pongo un botón para acceder a Evernote.

Le doy una funcionalidad al botón para ver que cuando lo pulso ocurre algo.

Incluyo la API de Evernote dentro del buildpath del proyecto, agregando los .jar de evernote-sdk-android-master\library\libs

El paso anterior no es válido. Lo que hago es incluir la librería de la API en el build path y en el Java build path.

Modifico el AndroidManifest.xml para incluir los nuevos permisos de Internet, y para incluir la autentiación OAuth de la que 
hace uso Evernote dentro de una Activity.

Ya se obtienen las notas del usuario y se muestran en la pantalla inicial tras haberse autenticado.

He agregado un menú desplegable para elegir si ordenar por fecha o por nombre. También agrego un botón para poder crear una nota.

Agregada la nueva activity para crear notas nuevas (CrearNotas.java) y añadido el código para que aparezca cuando se 
aprieta el botón de crear notas.

Ahora se pueden guardar notas al apretar el botón de guardado. Desde internet compruebo que las notas guardadas efectivamente
se han guardado.