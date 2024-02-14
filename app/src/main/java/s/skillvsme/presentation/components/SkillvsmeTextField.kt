package s.skillvsme.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import s.skillvsme.common.Fonts
import s.skillvsme.ui.theme.black
import s.skillvsme.ui.theme.darkGrey
import s.skillvsme.ui.theme.red

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun SkillvsmeTextField(
    value: String,
    onChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    onDone: () -> Unit = {},
    isValid: Boolean = true,
    errorMessage: String = "",
    label: String,
    hint: String,
    hintSize: Int? = null,
    trailingIcon: (() -> Unit)? = null,
    fieldDescription: String,
    LeadingIcon: ImageVector? = null,
    isLongText: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text ),
    enabled: Boolean = true,
    readOnly: Boolean = false,
    boldLabel: Boolean = true,
    keyboardActions: KeyboardActions? = null,
    action: (@Composable () -> Unit)? = null
) {
    val current = LocalFocusManager.current
    val softKeyboard = LocalSoftwareKeyboardController.current

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
        modifier = modifier
    ) {
        Text(
            fontFamily = Fonts.jostFontFamily,
            text = label,
            style = MaterialTheme.typography.body1,
            fontWeight = if (boldLabel) FontWeight.Bold else FontWeight.Normal
        )
        if (fieldDescription.isNotEmpty()) {
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                fontFamily = Fonts.jostFontFamily,
                text = fieldDescription,
                color = if (isValid) Color.Unspecified else Color.Red
            )
        }
        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                readOnly = readOnly,
                leadingIcon={
                    if (LeadingIcon != null) {
                        Icon(imageVector = LeadingIcon,
                            contentDescription ="",
                            tint = black
                        )
                    }
                },
                trailingIcon={
                    trailingIcon
                },
                enabled = enabled,
                modifier = Modifier
                    .weight(1f)
                    .height(if (isLongText) 150.dp else TextFieldDefaults.MinHeight)
                    .testTag(label + "1"),
                singleLine = !isLongText,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    placeholderColor = darkGrey,
                    unfocusedBorderColor = darkGrey,
                    focusedBorderColor = black
                ),
                value = value,
                onValueChange = {it ->
                    onChange(it)
                },
                shape = RoundedCornerShape(24.dp),
                keyboardOptions = keyboardOptions,
                placeholder = {
                    Text(
                        modifier = Modifier
                            .scale(1.6f),
                        fontFamily = Fonts.jostFontFamily,
                        text = hint,
                        fontSize = if (hintSize != null) hintSize.sp else 10.sp,
                        textAlign = TextAlign.Center,
                        color = darkGrey
                    ) },
                isError = !isValid,
                keyboardActions = keyboardActions ?: KeyboardActions(
                    onNext = {
                        current.moveFocus(FocusDirection.Down)
                    },
                    onDone = {
                        softKeyboard?.hide()
                        onDone()
                    }),

                )
            if (action != null) {
                Spacer(modifier = Modifier.width(8.dp))
                action()
            }
        }
        if (!isValid) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                fontFamily = Fonts.jostFontFamily,
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("${label} error"),
                text = errorMessage,
                style = MaterialTheme.typography.body1,
                color = red
            )
        }
    }
}