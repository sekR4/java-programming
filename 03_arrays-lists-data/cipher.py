def to_cipher(letter: str, key: int):
    """Translates incoming letter to its responding encrypted letter.

    Parameters
    ----------
    letter : str
    key : int

    Returns
    -------
    str
        encrypted letter
    """
    alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    encr = alphabet[key:]
    encr = encr + alphabet[:key]
    for idx, l in enumerate(alphabet.lower()):
        if l == letter.lower():
            return encr[idx]


def decipher(letter: str, key: int):
    alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    encr = alphabet[key:]
    encr = encr + alphabet[:key]

    for idx, l in enumerate(encr.lower()):
        if l == letter.lower():
            return alphabet[idx]


print(decipher("X", 23))


def decrypt_message(message: str, key: int = 23):
    txt = ""
    for letter in message:
        cipher = decipher(letter, key)
        if cipher:
            txt += cipher
        else:
            txt += letter

    return txt


message = "Lujyfwapvu huk zljbypaf hyl mbukhtluahs whyaz vm avkhf'z Pualyula."
message = "I love you."

for i in range(26):
    print(decrypt_message(message, i))

