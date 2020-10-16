export type FirstPins = 'X' | string
export type SecondPins = '/' | string
export type Score = null | number

export class Frame {
  private readonly _firstPins: FirstPins
  private readonly _secondPins: SecondPins

  constructor([firstPins, secondPins, _]) {
    this._firstPins = firstPins
    this._secondPins = secondPins
  }

  get firstPins(): number {
    return this._firstPins === 'X' ? 10 : Number(this._firstPins)
  }

  get secondPins(): number {
    if (this._secondPins !== '/') {
      return Number(this._secondPins)
    }

    return 10 - this.firstPins
  }

  public getScore(nextFrame?: Frame, nextNextFrame?: Frame): number | null {
    if (!this.isFinished(nextFrame, nextNextFrame)) {
      return null
    }

    if (this.isSpare()) {
      return 10 + nextFrame!.firstPins
    }

    if (this.isStrike()) {
      if (nextFrame!.isStrike()) {
        return 20 + nextNextFrame!.firstPins
      }

      return 10 + nextFrame!.firstPins + nextFrame!.secondPins
    }

    return this.firstPins + this.secondPins
  }

  public isFinished(nextFrame?: Frame, nextNextFrame?: Frame) {
    if (!this.isSpare() || !this.isStrike()) {
      return true
    }

    if (this.isSpare()) {
      return nextFrame !== null
    }

    if (this.isStrike() && nextFrame === null) {
      return false
    }

    if (this.isStrike() && !nextFrame!.isStrike()) {
      return nextFrame !== null
    }

    return nextNextFrame !== null
  }

  public isSpare(): boolean {
    return this._secondPins === '/'
  }

  public isStrike(): boolean {
    return this._firstPins === 'X'
  }
}
