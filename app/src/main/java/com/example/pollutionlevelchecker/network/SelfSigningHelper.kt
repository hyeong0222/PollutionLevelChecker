package com.example.pollutionlevelchecker.network

import android.content.Context
import com.example.pollutionlevelchecker.R
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.OkHttpClient
import timber.log.Timber
import java.io.InputStream
import java.security.KeyStore
import java.security.SecureRandom
import java.security.cert.Certificate
import java.security.cert.CertificateFactory
import java.security.cert.X509Certificate
import javax.inject.Inject
import javax.inject.Singleton
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManagerFactory
import javax.net.ssl.X509TrustManager

@Singleton
class SelfSigningHelper @Inject constructor(@ApplicationContext context: Context) {
    lateinit var tmf: TrustManagerFactory
    lateinit var sslContext: SSLContext

    init {
        val cf: CertificateFactory
        val ca: Certificate

        val caInput: InputStream

        try {
            cf = CertificateFactory.getInstance("X.509")

            caInput = context.resources.openRawResource(R.raw.sectigo_rsa_organization_validation_secure_server_ca)

            ca = cf.generateCertificate(caInput)
            Timber.d("ca = ${(ca as X509Certificate).subjectDN}")

            // Create a KeyStore containing our trusted CAs
            val keyStoreType = KeyStore.getDefaultType()
            val keyStore = KeyStore.getInstance(keyStoreType)
            with(keyStore) {
                load(null, null)
                keyStore.setCertificateEntry("ca", ca)
            }

            // Create a TrustManager that trusts the CAs in our KeyStore
            val tmfAlgorithm = TrustManagerFactory.getDefaultAlgorithm()
            tmf = TrustManagerFactory.getInstance(tmfAlgorithm)
            tmf.init(keyStore)

            // Create an SSLContext that uses our TrustManager
            sslContext = SSLContext.getInstance("TLS")
            sslContext.init(null, tmf.trustManagers, SecureRandom())

            caInput.close()
        } catch (exception: Exception) {
            exception.printStackTrace()
        }
    }

//    fun setSSLOkHttp(builder: OkHttpClient.Builder) =
//        builder.sslSocketFactory(sslContext.socketFactory, tmf.trustManagers[0] as X509TrustManager)
}