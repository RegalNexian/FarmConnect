package com.soumya.farmconnect.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private object AboutUsDefaults {
    val backgroundColor = Color(0xFFE8F3E8) // Slightly greener tint for farm theme
    val titleSize = 30.sp
    val sectionTitleSize = 22.sp
    val bodyTextSize = 16.sp
    val lineHeight = 24.sp
    val sectionSpacing = 24.dp
    val paragraphSpacing = 16.dp
}

@Composable
fun AboutUs() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = AboutUsDefaults.backgroundColor
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            AboutHeader()
            IntroductionSection()
            VisionSection()
            MissionSection()
            FeaturesSection()
            ImpactSection()
        }
    }
}

@Composable
private fun AboutHeader() {
    Text(
        text = "About FarmConnect",
        fontSize = AboutUsDefaults.titleSize,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(bottom = AboutUsDefaults.sectionSpacing),
        color = MaterialTheme.colorScheme.primary
    )
}

@Composable
private fun IntroductionSection() {
    SectionTitle("Who We Are")
    BodyText(
        "FarmConnect is a revolutionary agricultural platform dedicated to transforming the lives of farmers " +
                "through technology. We bridge the gap between farmers and consumers, creating a sustainable and " +
                "efficient agricultural ecosystem."
    )
}

@Composable
private fun VisionSection() {
    SectionTitle("Our Vision")
    BodyText(
        "We envision a future where every farmer has direct access to markets, fair prices, and the tools " +
                "they need to thrive. FarmConnect aims to be the catalyst for agricultural innovation and rural prosperity."
    )
}

@Composable
private fun MissionSection() {
    SectionTitle("Our Mission")
    BodyText(
        "FarmConnect's mission is to empower farmers with digital solutions that enhance their productivity " +
                "and profitability. We're committed to creating a transparent, efficient, and sustainable agricultural " +
                "marketplace."
    )

    Column(modifier = Modifier.padding(top = AboutUsDefaults.paragraphSpacing)) {
        FeatureItem("Eliminating intermediaries to maximize farmer profits")
        FeatureItem("Providing real-time market insights and price information")
        FeatureItem("Facilitating direct farmer-consumer connections")
        FeatureItem("Supporting sustainable farming practices")
    }
}

@Composable
private fun FeaturesSection() {
    SectionTitle("What We Offer")

    Column(modifier = Modifier.padding(top = AboutUsDefaults.paragraphSpacing)) {
        FeatureItem("Digital marketplace for agricultural products")
        FeatureItem("Secure payment and transaction system")
        FeatureItem("Market analysis and pricing tools")
        FeatureItem("Quality control and verification process")
        FeatureItem("Direct communication channels")
    }
}

@Composable
private fun ImpactSection() {
    SectionTitle("Our Impact")
    BodyText(
        "Through FarmConnect, we've helped thousands of farmers increase their income by up to 40% while " +
                "providing consumers with access to fresh, high-quality agricultural products. Our platform continues " +
                "to grow, fostering sustainable agricultural practices and rural development across the region."
    )
}

@Composable
private fun SectionTitle(text: String) {
    Text(
        text = text,
        fontSize = AboutUsDefaults.sectionTitleSize,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier.padding(vertical = AboutUsDefaults.paragraphSpacing),
        color = MaterialTheme.colorScheme.primary
    )
}

@Composable
private fun BodyText(text: String) {
    Text(
        text = text,
        fontSize = AboutUsDefaults.bodyTextSize,
        lineHeight = AboutUsDefaults.lineHeight,
        color = MaterialTheme.colorScheme.onSurface
    )
}

@Composable
private fun FeatureItem(text: String) {
    Row(
        verticalAlignment = Alignment.Top,
        modifier = Modifier.padding(bottom = 8.dp)
    ) {
        Text(
            text = "•",
            fontSize = AboutUsDefaults.bodyTextSize,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(end = 8.dp)
        )
        Text(
            text = text,
            fontSize = AboutUsDefaults.bodyTextSize,
            lineHeight = AboutUsDefaults.lineHeight,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AboutUsPreview() {
    AboutUs()
}