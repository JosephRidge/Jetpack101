package com.emobilis.jetpack101.ui.screens.seo

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.emobilis.jetpack101.R
import com.emobilis.jetpack101.data.model.SeoPlan
import com.emobilis.jetpack101.ui.components.PageTopSection
import com.emobilis.jetpack101.ui.theme.GOLD

@Composable
fun SEOScreen(modifier: Modifier = Modifier, innerPaddingValues: PaddingValues) {
    val scrollState = rememberScrollState()
    val screenHeightDp = LocalWindowInfo.current.containerSize.height.dp
    val screenWidthDp = LocalWindowInfo.current.containerSize.width.dp

    // Professional Dark Theme Colors
    val backgroundColor = Color(0xFF0A0A0A)
    val cardColor = Color(0xFF151515)
    val borderColor = Color(0xFF2A2A2A)
    val primaryTextColor = Color.White
    val secondaryTextColor = Color(0xFFCCCCCC)

    val seoServices = listOf(
        "Keyword research and analysis",
        "On-page optimization (meta tags, header tags etc)",
        "Link building and outreach",
        "Local SEO optimization",
        "Website audit and analysis",
        "Content optimization and creation"
    )

    val seoPackages = listOf<SeoPlan>(
        SeoPlan(
            tagName = "On-Page Optimization",
            unitPrice = 1000f,
            description = "Perfect for focusing on improving the elements of your website to improve its visibility.",
            advantages = listOf(
                "Keyword research & focusing on search engine ranking",
                "Meta tag optimization",
                "Internal linking"
            )
        ),
        SeoPlan(
            tagName = "Local SEO",
            unitPrice = 1500f,
            description = "Perfect for focusing on improving the elements of your website to improve its visibility.",
            advantages = listOf(
                "Improving website visibility in local searches",
                "Local Keyword research",
                "Local citations"
            )
        ),
        SeoPlan(
            tagName = "SEO Audit",
            unitPrice = 2500f,
            description = "Perfect for large businesses who need the Audit for analysis.",
            advantages = listOf(
                "Comprehensive analysis of your website's current SEO performance",
                "Technical issues",
                "Content and backlink profile"
            )
        ),
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .verticalScroll(scrollState)
            .padding(innerPaddingValues)
    ) {
        PageTopSection(
            image = R.drawable.seo,
            title = R.string.seo_title,
            paragraph = R.string.seo_text,
            imageHeight = screenHeightDp * 0.1f,
            imageWidth = screenWidthDp
        )

        // About SEO Section
        Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 24.dp)) {
            SectionTitle(title = "What is SEO?")
            Text(
                text = stringResource(R.string.seo_definition),
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 22.sp,
                    color = secondaryTextColor
                )
            )

            Spacer(modifier = Modifier.height(24.dp))

            SectionTitle(title = "Why is SEO important?")
            Text(
                text = stringResource(R.string.seo_importance),
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 22.sp,
                    color = secondaryTextColor
                )
            )
        }

        // SEO Services Section
        Spacer(modifier = Modifier.height(8.dp))
        SectionTitle(title = "Our SEO services", modifier = Modifier.padding(horizontal = 16.dp))

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(seoServices) { seoService ->
                Card(
                    modifier = Modifier.width(200.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = cardColor),
                    border = BorderStroke(1.dp, borderColor)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Box(
                            modifier = Modifier
                                .size(36.dp)
                                .background(GOLD.copy(alpha = 0.15f), RoundedCornerShape(8.dp)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "✓",
                                color = GOLD,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = seoService,
                            color = primaryTextColor,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            lineHeight = 20.sp
                        )
                    }
                }
            }
        }

        // SEO Packages Section
        Spacer(modifier = Modifier.height(24.dp))
        SectionTitle(title = "SEO Packages", modifier = Modifier.padding(horizontal = 16.dp))

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(seoPackages) { seoPackage ->
                Card(
                    modifier = Modifier.width(280.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = cardColor),
                    border = BorderStroke(1.dp, GOLD.copy(alpha = 0.3f))
                ) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        Text(
                            text = seoPackage.tagName,
                            color = GOLD,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(verticalAlignment = Alignment.Bottom) {
                            Text(
                                text = "USD ${seoPackage.unitPrice.toInt()}",
                                color = primaryTextColor,
                                fontSize = 28.sp,
                                fontWeight = FontWeight.ExtraBold
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "/ month",
                                color = secondaryTextColor,
                                fontSize = 14.sp,
                                modifier = Modifier.padding(bottom = 4.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = seoPackage.description,
                            color = secondaryTextColor,
                            fontSize = 13.sp,
                            lineHeight = 18.sp
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(1.dp)
                                .background(borderColor)
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Key Benefits:",
                            color = primaryTextColor,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        seoPackage.advantages.forEach { advantage ->
                            Row(modifier = Modifier.padding(vertical = 4.dp)) {
                                Text(
                                    text = "•",
                                    color = GOLD,
                                    fontSize = 16.sp,
                                    modifier = Modifier.padding(end = 8.dp)
                                )
                                Text(
                                    text = advantage,
                                    color = Color(0xFFDDDDDD),
                                    fontSize = 13.sp,
                                    lineHeight = 18.sp
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        Button(
                            onClick = {},
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(8.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = GOLD,
                                contentColor = Color.Black
                            ),
                            elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp)
                        ) {
                            Text(
                                text = "Get Plan",
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp
                            )
                        }
                    }
                }
            }
        }

        // Checkout Section
        Spacer(modifier = Modifier.height(24.dp))
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            SectionTitle(title = stringResource(R.string.seo_checkout_title))
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(R.string.seo_checkout_definition),
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 22.sp,
                    color = secondaryTextColor
                )
            )
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Button(
                    onClick = {},
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = GOLD,
                        contentColor = Color.Black
                    ),
                    elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp)
                ) {
                    Text(text = "Get started", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                }
                OutlinedButton(
                    onClick = {},
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = GOLD),
                    border = BorderStroke(1.dp, GOLD)
                ) {
                    Text(text = "Try Demo", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))
    }
}

// Reusable Professional Section Title Component
@Composable
private fun SectionTitle(title: String, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .width(4.dp)
                .height(24.dp)
                .background(GOLD)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = title,
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        )
    }
    Spacer(modifier = Modifier.height(16.dp))
}
