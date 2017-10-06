export default class Dollar {
  private amount: number

  constructor(amount: number) {
    this.amount = amount
  }

  public times(multiplications: number): Dollar {
    return new Dollar(this.amount * multiplications)
  }

  public equals(dollar: Dollar): boolean {
    if (dollar === null) {
      return false
    }

    return this.amount === dollar.amount
  }
}
